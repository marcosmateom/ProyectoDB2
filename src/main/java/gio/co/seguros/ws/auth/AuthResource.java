/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.seguros.ws.auth;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.bson.Document;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author migue
 */
@Path("/auth")

public class AuthResource {

    protected List<Document> authList;

    @GET
    @Path("/getAuth")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Document> getAuth(
            @QueryParam("dpi") String dpi,
            @QueryParam("idAuth") int idAuth,
            @QueryParam("idCita") int idCita) {
        //Obtener # del hospital
        makeList(dpi, idAuth, idCita);

        return authList;
    }

    @POST
    @Path("/addAuth")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAuth(
            @QueryParam("hospital") int hospNum,
            @QueryParam("fecha") String fechaCita,
            @QueryParam("servicio") String serv,
            @QueryParam("nameP") String nameP,
            @QueryParam("monto") String monto,
            @QueryParam("dpi") String dpi,
            @QueryParam("idCita") int idCita) {
        //Verificar si el cliente tiene seguro y si sí que devuelva el porcentaje
        String porcentaje = verClienteSeg(dpi);
        if (!porcentaje.equals("")) {
            //Verificar si el seguro cubre ese servicio en ese hospital
            Boolean servHosp = servHospVerify(hospNum, serv);
            if (servHosp) {
                Boolean answ;
                String estado = "Aprobado";
                answ = addNewAuth(hospNum, fechaCita, serv, estado, dpi, monto, porcentaje, idCita);
                if (answ) {
                    return Response.status(200).type(MediaType.APPLICATION_JSON).entity("{\"in\":1}").build();
                } else {
                    return Response.status(200).type(MediaType.APPLICATION_JSON).entity("{\"in\":0}").build();
                }
            } else {
                return Response.status(200).type(MediaType.APPLICATION_JSON).entity("{\"serv\":0}").build();
            }
        } else {
            return Response.status(200).type(MediaType.APPLICATION_JSON).entity("{\"client\":0}").build();
        }

    }

    @PUT
    @Path("/updateAuth")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateAuth(
            @QueryParam("idAuth") int idAuth,
            @QueryParam("hospital") int hospNum,
            @QueryParam("fecha") String fechaCita,
            @QueryParam("servicio") String serv,
            @QueryParam("estado") String estado,
            @QueryParam("nameP") String nameP,
            @QueryParam("monto") String monto,
            @QueryParam("porcentaje") String porcentaje,
            @QueryParam("dpi") String dpi,
            @QueryParam("idCita") int idCita) {
        if (estado == null) {
            estado = "Pendiente";
        }
        Boolean answ;
        answ = updateAuth(idAuth, hospNum, fechaCita, serv, estado, dpi, monto, porcentaje, idCita);
        if (answ) {
            return Response.status(200).type(MediaType.APPLICATION_JSON).entity("{\"up\":1}").build();
        } else {
            return Response.status(200).type(MediaType.APPLICATION_JSON).entity("{\"up\":0}").build();
        }
    }

    protected void makeList(String dpi, int idAuth, int idCita) {
        try {
            //Conexion mongo
            MongoCollection<Document> coll = CollAuth.collAuth();
            List<Document> auths;
            if (dpi != null && !dpi.equals("")) {
                //query en base al dpi
                auths = (List<Document>) coll.find(new BasicDBObject("dpi", dpi)).into(new ArrayList<Document>());
            } else if (idAuth > 0) {
                auths = (List<Document>) coll.find(new BasicDBObject("_id", idAuth)).into(new ArrayList<Document>());
            } else if (idCita > 0) {
                auths = (List<Document>) coll.find(new BasicDBObject("idCita", idCita)).into(new ArrayList<Document>());
            } else {
                //Jalar todas las autorizaciones
                auths = (List<Document>) coll.find().into(new ArrayList<Document>());
            }
            authList = auths;
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private Boolean addNewAuth(int hospNum, String fechaCita, String serv, String estado, String dpi, String monto, String porcentaje, int idCita) {
        MongoCollection<Document> coll = CollAuth.collAuth();
        try {
            int id = 0;
            //Encontrar el ID del ultimo documento
            List<Document> _idNum;
            int limit = 1;
            Document sort = new Document();
            //Buscar el id mas grande
            sort.append("_id", -1.0);
            _idNum = (List<Document>) coll.find().sort(sort).limit(limit).into(new ArrayList<Document>());
            id = _idNum.get(0).getInteger("_id");
            //Insertar el documento
            Document doc = new Document("hospital", hospNum)
                    .append("fecha", fechaCita)
                    .append("servicio", serv)
                    .append("estado", estado)
                    .append("dpi", dpi)
                    .append("monto", monto)
                    .append("porcentaje", porcentaje)
                    .append("idCita", idCita)
                    .append("_id", id + 1);
            coll.insertOne(doc);
            return true;
        } catch (MongoException | ClassCastException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Boolean updateAuth(int idAuth, int hospNum, String fechaCita, String serv, String estado, String dpi, String monto, String porcentaje, int idCita) {
        MongoCollection<Document> coll = CollAuth.collAuth();
        try {
            BasicDBObject updateFields = new BasicDBObject();
            updateFields.append("hospital", hospNum);
            updateFields.append("fecha", fechaCita);
            updateFields.append("servicio", serv);
            updateFields.append("estado", estado);
            updateFields.append("dpi", dpi);
            updateFields.append("monto", monto);
            updateFields.append("idCita", idCita);
            updateFields.append("porcentaje", porcentaje);
            BasicDBObject searchQuery = new BasicDBObject().append("_id", idAuth);
            BasicDBObject setQuery = new BasicDBObject();
            setQuery.append("$set", updateFields);
            coll.updateOne(searchQuery, setQuery);
            return true;
        } catch (MongoException | ClassCastException e) {
            e.printStackTrace();
            return false;
        }
    }

    //Este verifica que el servicio que se quiere realizar, en el hospital que se eligio, lo cubre el seguro
    private Boolean servHospVerify(int hospNum, String serv) {
        try {
            // Construct data
            StringBuilder dataBuilder = new StringBuilder();
            dataBuilder.append(URLEncoder.encode("hospNo", "UTF-8")).append('=').append(URLEncoder.encode(Integer.toString(hospNum), "UTF-8")).append("&").
                    append(URLEncoder.encode("servicio", "UTF-8")).append('=').append(URLEncoder.encode(serv, "UTF-8"));
            // Send data
            URL url = new URL("http://localhost:8080/proyectoDB2-seguro/CoberturaS");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(dataBuilder.toString());
            wr.flush();

            // Get the response
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuffer response2 = new StringBuffer();
            while ((line = rd.readLine()) != null) {
                response2.append(line);
            }
            JSONObject obj = new JSONObject(response2.toString());
            Boolean answ = obj.getBoolean("respuesta");
            wr.close();
            rd.close();
            if (answ) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private String verClienteSeg(String dpi) {
        String porcentaje = "";
        try {
            // Send data
            URL url = new URL("http://localhost:8080/proyectoDB2-seguro/GetCliente?dpi=" + dpi);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);

            // Get the response
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuffer response2 = new StringBuffer();
            while ((line = rd.readLine()) != null) {
                response2.append(line);
            }
            JSONArray arrObj = new JSONArray(response2.toString());
            JSONObject obj = arrObj.getJSONObject(0);
            porcentaje = obj.getString("cobertura");
            rd.close();
            if (!porcentaje.equals("")) {
                return porcentaje;
            } else {
                return porcentaje = "";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return porcentaje = "";
        }
    }
}

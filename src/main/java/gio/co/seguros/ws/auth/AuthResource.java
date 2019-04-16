/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.seguros.ws.auth;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
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
        makeList(dpi,idAuth,idCita);

        return authList;
    }

    @POST
    @Path("/addAuth")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAuth(
            @QueryParam("hospital") String hospNum,
            @QueryParam("fecha") String fechaCita,
            @QueryParam("servicio") String serv,
            @QueryParam("estado") String estado,
            @QueryParam("nameP") String nameP,
            @QueryParam("monto") String monto,
            @QueryParam("porcentaje") String porcentaje,
            @QueryParam("dpi") String dpi,
            @QueryParam("idCita") String idCita) {
        if(estado==null){
            estado = "Pendiente";
        }
        Boolean answ;                                                               
        answ = addNewAuth(hospNum,fechaCita,serv,estado,dpi,monto,porcentaje);
        if (answ) {
            return Response.status(200).type(MediaType.APPLICATION_JSON).entity("{\"in\":1}").build();
        } else {
            return Response.status(200).type(MediaType.APPLICATION_JSON).entity("{\"in\":0}").build();
        }
    }
    
    @PUT
    @Path("/updateAuth")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateAuth(
            @QueryParam("hospital") String hospNum,
            @QueryParam("fecha") String fechaCita,
            @QueryParam("servicio") String serv,
            @QueryParam("estado") String estado,
            @QueryParam("nameP") String nameP,
            @QueryParam("monto") String monto,
            @QueryParam("porcentaje") String porcentaje,
            @QueryParam("dpi") String dpi) {
        if(estado==null){
            estado = "Pendiente";
        }
        Boolean answ;                                                               
        answ = updateAuth(hospNum,fechaCita,serv,estado,dpi,monto,porcentaje);
        if (answ) {
            return Response.status(200).type(MediaType.APPLICATION_JSON).entity("{\"up\":1}").build();
        } else {
            return Response.status(200).type(MediaType.APPLICATION_JSON).entity("{\"up\":0}").build();
        }
    }

    protected void makeList(String dpi,int idAuth,int idCita) {
        try {
            //Conexion mongo
            MongoCollection<Document> coll = CollAuth.collAuth();
            List<Document> auths;
            if (dpi != null&&!dpi.equals("")) {
                //query en base al dpi
                auths = (List<Document>) coll.find(new BasicDBObject("dpi", dpi)).into(new ArrayList<Document>());
            } else if(idAuth > 0){
                auths = (List<Document>) coll.find(new BasicDBObject("_id", idAuth)).into(new ArrayList<Document>());
            } 
            else if(idCita > 0){
                auths = (List<Document>) coll.find(new BasicDBObject("idCita", idCita)).into(new ArrayList<Document>());
            } 
            else {
                //Jalar todas las autorizaciones
                auths = (List<Document>) coll.find().into(new ArrayList<Document>());
            }
            authList = auths;
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private Boolean addNewAuth(String hospNum, String fechaCita, String serv, String estado, String dpi, String monto, String porcentaje) {
        MongoCollection<Document> coll = CollAuth.collAuth();
        try {
            //Encontrar el ID del ultimo documento
            List<Document> _idNum;
            int limit = 1;
            Document sort = new Document();
            //Buscar el id mas grande
            sort.append("_idAuth", -1.0);
            _idNum = (List<Document>) coll.find().sort(sort).limit(limit).into(new ArrayList<Document>());
            int id = _idNum.get(0).getInteger("_id");
            //Insertar el documento
            Document doc = new Document("hospital", hospNum)
                    .append("fecha", fechaCita)
                    .append("servicio", serv)
                    .append("estado", estado)
                    .append("dpi", dpi)
                    .append("monto", monto)
                    .append("porcentaje", porcentaje)
                    .append("_id", id + 1);
            coll.insertOne(doc);
            return true;
        } catch (MongoException | ClassCastException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Boolean updateAuth(String hospNum, String fechaCita, String serv, String estado, String dpi, String monto, String porcentaje) {
                        MongoCollection<Document> coll = CollAuth.collAuth();
                        try {
                            BasicDBObject updateFields = new BasicDBObject();
                            updateFields.append("hospital", hospNum);
                            updateFields.append("fecha", fechaCita);
                            updateFields.append("servicio", serv);
                            updateFields.append("estado", estado);
                            updateFields.append("dpi", dpi);
                            updateFields.append("monto", monto);
                            updateFields.append("porcentaje", porcentaje);
                            BasicDBObject searchQuery = new BasicDBObject().append("dpi", dpi).append("fecha", fechaCita).append("hospital", hospNum);;
                           BasicDBObject setQuery = new BasicDBObject();
                           setQuery.append("$set", updateFields);
                           coll.updateOne(searchQuery, setQuery);
                           return true;
                        } catch(MongoException | ClassCastException e){
                            e.printStackTrace();
                            return false;
                        }
    }

}

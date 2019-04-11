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
import gio.co.seguros.ws.auth.*;
import javax.ws.rs.core.Response;

/**
 *
 * @author C.V
 */
@Path("/auth")

public class AuthResource {

    protected List<Document> authList;

    @GET
    @Path("/getAuth")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Document> getAuth(
            @QueryParam("dpi") String dpi) {
        //Obtener # del hospital
        makeList(dpi);

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
            @QueryParam("dpi") String dpi) {
        Boolean answ;                                                               //Respuesta del addUpdateCita
        answ = addNewAuth(hospNum,fechaCita,serv,estado,dpi,monto,porcentaje);
        if (answ) {
            return Response.status(200).type(MediaType.APPLICATION_JSON).entity("{\"in\":1}").build();
        } else {
            return Response.status(200).type(MediaType.APPLICATION_JSON).entity("{\"in\":0}").build();
        }
    }

    protected void makeList(String dpi) {
        try {
            //Conexion mongo
            MongoCollection<Document> coll = CollAuth.collAuth();
            List<Document> auths;
            if (dpi != null) {
                //query en base al dpi
                auths = (List<Document>) coll.find(new BasicDBObject("dpi", dpi)).into(new ArrayList<Document>());
            } else {
                //jalar todas las autorizaciones
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
            Document doc = new Document("hospital", hospNum)
                    .append("fecha", fechaCita)
                    .append("servicio", serv)
                    .append("estado", estado)
                    .append("dpi", dpi)
                    .append("monto", monto)
                    .append("porcentaje", porcentaje);
            coll.insertOne(doc);
            return true;
        } catch (MongoException | ClassCastException e) {
            e.printStackTrace();
            return false;
        }
    }

}

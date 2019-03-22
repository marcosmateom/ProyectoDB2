/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.seguros.Usuario;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Projections;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.bson.Document;

/**
 *
 * @author C.V
 */

@Path("/usuario")

public class UsuarioResource {
    
        /*protected List<Usuarios> patientsList = new ArrayList<Usuarios>();
        @GET
        @Path("/getUsuario")
        @Produces(MediaType.APPLICATION_JSON)
        public List<Usuarios> getUsuario(){
        //Obtener # del hospital
        makeList();
        
        return userList;
        }*/
    
    protected List<Usuarios> userList = new ArrayList<Usuarios>();
        @GET
        @Path("/getUsuario")
        @Produces(MediaType.APPLICATION_JSON)
        public List<Usuarios> getUsuario(){
        //Obtener # del hospital
        makeList();
        
        return userList;
        }
    
    
        
        @GET
        @Path("/getUsuario/{uId}")
        @Produces(MediaType.APPLICATION_JSON)
        public Response getMsg(@PathParam("uId") String name) {
            String output = "<html> " + "<title>" + "Java WebService Example" + "</title>"  + "<body><h1><div style='font-size: larger;'>"
                    + "Hello <span style='text-transform: capitalize; color: green;'>" + name + "</span></div></h1></body>" + "</html>";
            return Response.status(200).entity(output).build();
        }
        
        protected void makeList(){
        
        //Conexion con db oracle
        MongoCollection<Document> coll = gio.co.seguros.collUsuarios.collUsuarios();
            //Response info
            try{
                
                
                
            }catch(Exception e){
                System.err.println(e);
            }
    }
    
}



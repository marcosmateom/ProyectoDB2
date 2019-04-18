/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.seguros.Servicios;

import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.bson.Document;

/**
 *
 * @author C.V
 */

@Path("/servicios")

public class ServiciosResource {
    
        protected List<Document> servicesList;// = new List<Document>();
        @GET
        @Path("/getServicios")
        @Produces(MediaType.APPLICATION_JSON)
        public List<Document> getServicios(){
        //Obtener # del hospital
        makeList();
        
        return servicesList;
        }
    
    /*protected JSONArray userList = new JSONArray();
        @GET
        @Path("/getUsuario")
        @Produces(MediaType.APPLICATION_JSON)
        public JSONArray getUsuario(){
        //Obtener # del hospital
        makeList();
        
        return userList;
        }*/
    
    
        

        
        protected void makeList(){
        
        //Conexion con db oracle
        
            //Response info
            try{
                MongoCollection<Document> coll = gio.co.seguros.collServicios.collservicios();
                List<Document> servicios = (List<Document>) coll.find().into( new ArrayList<Document>());
                servicesList = servicios;

                
            }catch(Exception e){
                System.err.println(e);
            }
    }
    
}












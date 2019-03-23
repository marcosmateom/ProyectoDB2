/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.seguros.Poliza;

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

@Path("/poliza")

public class PolizaResource {
    
        protected List<Document> polizaList;// = new List<Document>();
        @GET
        @Path("/getPoliza")
        @Produces(MediaType.APPLICATION_JSON)
        public List<Document> getPoliza(){
        //Obtener # del hospital
        makeList();
        
        return polizaList;
        }
    
        protected void makeList(){
        
        //Conexion con db oracle
        
            //Response info
            try{
                MongoCollection<Document> coll = gio.co.seguros.collPoliza.collpoliza();
                List<Document> polizas = (List<Document>) coll.find().into( new ArrayList<Document>());
                polizaList = polizas;

                
            }catch(Exception e){
                System.err.println(e);
            }
    }
    
}



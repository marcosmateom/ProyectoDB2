/*-
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.seguros.Cliente;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author C.V
 */

@Path("/cliente")

public class ClienteResource {
    
        protected List<Document> clientsList;// = new List<Document>();
        @GET
        @Path("/getCliente")
        @Produces(MediaType.APPLICATION_JSON)
        public List<Document> getCliente(
            @QueryParam("dpi") String cId){
        //Obtener # del hospital
        makeList(cId);
        
        return clientsList;
        }
    
        protected void makeList(String cId){
        
        //Conexion con db oracle
        
            //Response info
            try{
                
                MongoCollection<Document> coll = gio.co.seguros.collClientes.collclientes();
                
                if(cId!=null){
                    //Query con el filtro para seleccionar un paciente
                    //sql = "select * from pacientes where paciente_id ="+pId+" order by paciente_id";
                    List<? extends Bson> pipeline = Arrays.asList(
                    new Document()
                            .append("$match", new Document()
                                    .append("documentoIdentificacion", cId)
                            ), 
                    new Document()
                            .append("$lookup", new Document()
                                    .append("from", "polizas")
                                    .append("localField", "tipo_poliza")
                                    .append("foreignField", "tipo_poliza")
                                    .append("as", "join")
                            ), 
                    new Document()
                            .append("$replaceRoot", new Document()
                                    .append("newRoot", new Document()
                                            .append("$mergeObjects", Arrays.asList(
                                                    new Document()
                                                            .append("$arrayElemAt", Arrays.asList(
                                                                    "$join",
                                                                    0.0
                                                                )
                                                            ),
                                                    "$$ROOT"
                                                )
                                            )
                                    )
                            )
            );
                    List<Document> clientes = (List<Document>) coll.aggregate(pipeline).into( new ArrayList<Document>());
                    clientsList = clientes;
                }
                else{
                    //Query de todos los pacientes
                    //MongoCollection<Document> coll = gio.co.seguros.collPoliza.collpoliza();
                    List<? extends Bson> pipeline = Arrays.asList(
                    new Document()
                            .append("$lookup", new Document()
                                    .append("from", "polizas")
                                    .append("localField", "tipo_poliza")
                                    .append("foreignField", "tipo_poliza")
                                    .append("as", "join")
                            ), 
                    new Document()
                            .append("$replaceRoot", new Document()
                                    .append("newRoot", new Document()
                                            .append("$mergeObjects", Arrays.asList(
                                                    new Document()
                                                            .append("$arrayElemAt", Arrays.asList(
                                                                    "$join",
                                                                    0.0
                                                                )
                                                            ),
                                                    "$$ROOT"
                                                )
                                            )
                                    )
                            )
            );
                    List<Document> clientes = (List<Document>) coll.aggregate(pipeline).into( new ArrayList<Document>());
                    clientsList = clientes;
                }
                
                /*MongoCollection<Document> coll = gio.co.seguros.collClientes.collclientes();
                List<Document> clientes = (List<Document>) coll.find().into( new ArrayList<Document>());
                clientsList = clientes;*/
                //String a = clientes.get(0).toJson();
                //String a2 = a;

                
            }catch (MongoException e) {
                System.err.println(e);
            }
            
    }
    
}

















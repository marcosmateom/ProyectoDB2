/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.seguros.ws.historial;

import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import gio.co.seguros.ws.auth.CollAuth;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.bson.Document;

/**
 *
 * @author C.V
 */
@Path("/hist")
public class HistorialResource {
    protected List<Document> histList;
    @GET
    @Path("/getHist")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Document> getHist(
            @QueryParam("hospital") int hospital) {
        //Obtener # del hospital
        makeList(hospital);

        return histList;
    }
    
    @POST
    @Path("/addHist")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addHist(
            @QueryParam("hospital") int hospNum,
            @QueryParam("fecha") String fechaCita,
            @QueryParam("doctor") String doctor,
            @QueryParam("diagnostico") String diagnostico,
            @QueryParam("resultados") String resultados,
            @QueryParam("medicinas") String medicinas,
            @QueryParam("pasos") String pasos,
            @QueryParam("observaciones") String observaciones,
            @QueryParam("dpi") String dpi,
            @QueryParam("categoria") String categoria,
            @QueryParam("subcat") String subcat,
            @QueryParam("idCita") int idCita) {
        
        //LLamar al metodo para insertar historial
        Boolean answ;
        answ = addNewHist(hospNum, fechaCita, doctor, diagnostico, resultados, medicinas, pasos, observaciones, dpi, categoria, subcat, idCita);
        if (answ) {
            return Response.status(200).type(MediaType.APPLICATION_JSON).entity("{\"in\":1}").build();
        } else {
            return Response.status(200).type(MediaType.APPLICATION_JSON).entity("{\"in\":0}").build();
        }
        

    }
    
    protected void makeList(int hospital) {
        try {
            //Conexion mongo
            MongoCollection<Document> coll =CollHistorial.collHistorial();
            //LLamar la coleccion de historiales
            List<Document> hists = (List<Document>) coll.find().into(new ArrayList<Document>());
            //Lista donde se van a insertar los historiales que no son del hospital que solicita los historiales
            List<Document> listaF = new ArrayList<Document>();
            int cant = hists.size();
            for (int i = 0; i < cant; i++){
                //Get del numero de hospital en el documento
                //String a = hists.get(i).getString("hospital");
                int s = hists.get(i).getInteger("hospital");
                //validacion de si la cita fue hecha en el hospital que solisita historiales
                if (s != hospital){
                    listaF.add(hists.get(i));
                }
            }
            histList= listaF;
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    private Boolean addNewHist(int hospNum, String fechaCita, String doctor, String diagnostico, String resultados, String medicinas, String pasos, String observaciones, String dpi, String categoria, String subcat, int idCita) {        
        MongoCollection<Document> coll = CollHistorial.collHistorial();
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
                    .append("idCita", idCita)
                    .append("doctor", doctor)
                    .append("diagnostico", diagnostico)
                    .append("resultados", resultados)
                    .append("medicinas", medicinas)
                    .append("pasos", pasos)
                    .append("observaciones", observaciones)
                    .append("dpi", dpi)
                    .append("categoria", categoria)
                    .append("subcat", subcat)
                    .append("_id", id + 1);
            coll.insertOne(doc);
            return true;
        } catch (MongoException | ClassCastException e) {
            e.printStackTrace();
            return false;
        }
    }
}

































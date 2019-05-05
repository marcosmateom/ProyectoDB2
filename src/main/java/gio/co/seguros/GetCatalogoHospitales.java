/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.seguros;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

@WebServlet("/GetCatalogoServicios")

/**
 *
 * @author C.V
 */
public class GetCatalogoHospitales extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public GetCatalogoHospitales() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        MongoCollection<Document> coll = gio.co.seguros.collServicios.collservicios();
        try {
            List<Document> coberturas = (List<Document>) coll.find().into(new ArrayList<Document>());
            //out.println("hola");
            int largo = coberturas.size();
            
            out.println(largo);
            //out.println(largo);
            /*List<String> stringArray;

            JSONArray jsArray = new JSONArray();

            for (int h = 0; h < largo; h++) {
                Document doc = coberturas.get(h);
                List<Document> servicios = (List<Document>) doc.get("servicios");
                int larser = 

                stringArray.add(servicios.toArray(new String[0]));
            }

            for (int i = 0; i < stringArray.length; i++) {
                jsArray.put(stringArray[i]);
            }
            out.println(jsArray);*/

            /*JSONObject ja = new JSONObject();
                            ja.put("",jsArray);
                            out.println(ja);
                            //String[] stringArray;
                            for(Document cobertura :  coberturas){
                                
                                List<Document> servicios =(List<Document>) cobertura.get("servicios");
                                for(Document servicio : servicios){
                                                                        
                                    //out.println("servicio: "+cobertura.getString("hospital"));
                                    //out.println("servicioxd: "+servicio);
                                }
                            
                           
                            }
                            /*
                            
                            FindIterable<Document> fi = coll.find();
                            MongoCursor<Document> cursor = fi.iterator();
                            try {
                                while(cursor.hasNext()) {
                                    Document doc = cursor.next();
        
                                    List list = new ArrayList(doc.values());
                                    System.out.print(list.get(1));
                                    System.out.print(": ");
                                    System.out.println(list.get(2));
                                    //ja.put("",cursor.next());
                                    //out.println(cursor.next().toJson());
                                }
                            } finally {
                                cursor.close();
                            }
             */
        } catch (MongoException | ClassCastException e) {
            e.printStackTrace();
        }

    }

}




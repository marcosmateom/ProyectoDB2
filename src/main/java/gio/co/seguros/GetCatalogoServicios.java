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
public class GetCatalogoServicios extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public GetCatalogoServicios() {
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

            //for(int i;i<largo;i++){
            Document doc = coberturas.get(2);
            List<Document> servicios = (List<Document>) doc.get("servicios");

            String[] stringArray = servicios.toArray(new String[0]);

            JSONArray jsArray = new JSONArray();
            for (int i = 0; i < stringArray.length; i++) {
                jsArray.put(stringArray[i]);
            }
            out.println(jsArray);

            
        } catch (MongoException | ClassCastException e) {
            e.printStackTrace();
        }

    }

}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.seguros;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;
import static com.mongodb.client.model.Filters.eq;
import org.json.JSONObject;

@WebServlet("/CoberturaS")

/**
 *
 * @author C.V
 */
public class CoberturaS extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    public CoberturaS() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
        
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                String hospNo, servicio;
                hospNo = request.getParameter("hospNo").toString();
                //hospNo = "1";
                //servicio = "Sangre";
                servicio = request.getParameter("servicio").toString();		/*try {*/
			MongoCollection<Document> coll = gio.co.seguros.collServicios.collservicios();
                        try {
                            List<Document> coberturas = (List<Document>) coll.find(new BasicDBObject("hospital", hospNo)).into( new ArrayList<Document>());
                            int index = coberturas.size();
                            Document doc = coberturas.get(0);
                            List<Document> servicios = (List<Document>) doc.get("servicios");
                            String res = "false";
                            String[] stringArray = servicios.toArray(new String[0]);
                            String a = "a";
                            int i =0;
                            String servi = "";
                            for  (i = 0; i < stringArray.length; i++){
                                servi = stringArray[i];
                                if(servi.equals(servicio)){
                                    res = "true";
                                }
                                
                            }
                            JSONObject resp= new JSONObject("{respuesta:"+res+"}");

                            out.println(resp.toString());
                            a="h";
                            //request.setAttribute("res", res);
                            //RequestDispatcher rd = request.getRequestDispatcher("p.jsp");
                            //rd.forward(request, response);
                            
                        
                        } catch(MongoException | ClassCastException e){
                            e.printStackTrace();
                        }
	}
    
}



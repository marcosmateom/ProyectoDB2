/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.seguros.Servicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author C.V
 */

@WebServlet("/GetServices")

public class GetServices extends HttpServlet {
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetServices() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    // Generar jsons
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Response info
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            String hosp = request.getParameter("hospnum");
            //String hospcan = request.getParameter("hospcan");
            String hospname;
            int hospNum = Integer.parseInt(hosp);
            int numero;
            String url = "http://25.74.104.162:8080/proyectoDB2-seguro/restS/servicios/getServicios";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response2 = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response2.append(inputLine);
            }
            in.close();
            JSONArray servicios = new JSONArray(response2.toString());
            
            int n = servicios.length();
            
            int nah = servicios.length();
            //out.println(nah);
            if(((hosp != null) && !(hosp.equals("")))){
                for(int i = 0; i<n; i++){
                JSONObject hospitales = servicios.getJSONObject(i);
                //out.println(hospitales);
                hospname = hospitales.getString("hospital");
                numero = Integer.parseInt(hospname);
                if(hospNum == numero){
                //out.println("hospitaljuju: "+hospname);
                JSONArray array_servicios = hospitales.getJSONArray("servicios");
                out.println(array_servicios);
                }
                }                                    
            } else {
                for(int i = 0; i<n; i++){
                JSONObject hospitales = servicios.getJSONObject(i);
                out.println(hospitales);
                }
                
            }
            
            
            
            

            
            
            
            /*
            JSONObject obj_JSONObject = new JSONObject(response.toString());
            JSONArray obj_JSONArray = obj_JSONObject.getJSONArray("servicios");
            out.println(obj_JSONArray);
            out.println("--" + obj_JSONArray.length());*/
            
            
            /*JSONObject obj_JSONObject2 = obj_JSONArray.getJSONObject(5);
            System.out.println("--element 5---");
            System.out.println(obj_JSONObject2);
            JSONArray address_components_array = obj_JSONObject2.getJSONArray("address_components");
            JSONObject obj_JSONObject3 = address_components_array.getJSONObject(0);
            System.out.println("long_name-" + obj_JSONObject3.getString("long_name"));
            System.out.println("short_name-" + obj_JSONObject3.getString("short_name"));
            System.out.println("formatted_address-" + obj_JSONObject2.getString("formatted_address"));
            System.out.println("formatted_address-" + obj_JSONObject2.getString("place_id"));*/
            
            
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
    
}






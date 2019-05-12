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

@WebServlet("/GetHospitales")

public class GetHospitales extends HttpServlet {
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetHospitales() {
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
            
            //String hosp = request.getParameter("hospnum");
            //String hospcan = request.getParameter("hospcan");
            String hospname;
            //int hospNum = Integer.parseInt(hosp);
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
            JSONArray hospis = new JSONArray(response2.toString());
            
            int n = hospis.length();
            
                       
            
            JSONArray list = new JSONArray();
                for(int i = 0; i<n; i++){
                JSONObject hospitales = hospis.getJSONObject(i);
                //out.println(hospitales);
                
                
                JSONObject jo = hospis.getJSONObject(i);
                if(jo.optString("hospital")!= ""){
                
                    hospname = jo.getString("hospital");
                                    
                    //out.println(hospname);
                    jo.put("hospital", hospname);
                    list.put(jo);
                    //JSONArray array_hospitales = hospis.getJSONArray("hospital");
                    //out.println(array_hospitales);
                    //list.put(jo);
                    //hospname = "";
                }
                }                                   
            
            out.println(list);
            
   
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
    
}
















































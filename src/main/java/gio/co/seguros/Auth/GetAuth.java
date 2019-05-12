/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.seguros.Auth;

/**
 *
 * @author migue
 */

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

/**
 * Servlet implementation class GetAuth
 */
@WebServlet("/GetAuth")
public class GetAuth extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public static String hospitalNum = "2";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAuth() {
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
            String url;
            String parDpi = request.getParameter("dpi");
            String parIdCita = request.getParameter("idCita");
            String parHospNum = request.getParameter("hospNum");
            if ((parDpi != null) && !(parDpi.equals(""))) {
                String dpi = parDpi;
                url = "http://localhost:8080/proyectoDB2-seguro/restAuth/auth/getAuth?dpi=" + dpi;
            } else if ((parIdCita != null) && !(parIdCita.equals(""))&&(parHospNum != null) && !(parHospNum.equals(""))) {
                String IdCita = parIdCita;
                String hospNum = parHospNum;
                url = "http://localhost:8080/proyectoDB2-seguro/restAuth/auth/getAuth?idCita=" + IdCita+"&hospNum="+hospNum;
            } else {
                url = "http://localhost:8080/proyectoDB2-seguro/restAuth/auth/getAuth";
            }
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
            //print in String
            out.println(response2.toString());
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
    
}

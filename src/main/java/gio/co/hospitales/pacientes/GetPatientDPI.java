package gio.co.hospitales.pacientes;

import gio.co.seguros.getHospIp;
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
 * Servlet implementation class GetPatient
 */
@WebServlet("/GetPatientDPI")
public class GetPatientDPI extends HttpServlet {

    private static final long serialVersionUID = 1L;
    //CAMBIADO POR PRUEBAS
    //public static String hospitalNum = "3";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPatientDPI() {
        super();
        // TODO Auto-generated constructor stub
    }

    // Generar jsons
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Response info
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String hospN = request.getParameter("hosp");
        
       
        try {
            String url;
            String ipHost = getHospIp.getIP(Integer.parseInt(hospN));
            String parPId = request.getParameter("dpi");
            if ((parPId != null) && !(parPId.equals(""))) {
                //int pId = Integer.parseInt(request.getParameter("pId"));
                
                url = "http://"+ipHost+":8080/proyectoDB2-Hospital1/restP/patient/getPatientDPI?dpi=" + parPId;
            } else {
                url = "http://"+ipHost+":8080/proyectoDB2-Hospital1/restP/patient/getPatientDPI";
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














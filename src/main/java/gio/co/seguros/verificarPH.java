package gio.co.seguros;

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
import org.json.*;
import com.google.gson.*;
import java.io.File;
/*import com.google.gson.GsonBuilder;*/



/**
 * Servlet implementation class GetPatient
 */


                


@WebServlet("/verificarPH")
public class verificarPH extends HttpServlet {

    public static int hayono = 0;
    private static final long serialVersionUID = 1L;
    public static String hospitalNum = "3";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public verificarPH() {
        super();
        // TODO Auto-generated constructor stub
    }

    // Generar jsons
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Response info
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String url22, urlAdd;
            String parDPI = request.getParameter("pId");
            String parServ = request.getParameter("servicioId");
            String parHosp = request.getParameter("hospnum");
            
            //out.println(hayono);
            //out.println(parDPI);            
            //out.println(parServ);
            
            double DPIcliente = Double.parseDouble(parDPI);
            url22 = "http://localhost:8080/proyectoDB2-Hospitales/restP/patient/getPatientDPI?dpi="+DPIcliente;
            
            urlAdd = "http://localhost:8080/proyectoDB2-seguro/AddPatient";

            URL obj = new URL(url22);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
           
            int responseCode = con.getResponseCode();
            //out.println("Response code: "+responseCode);
            
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            out.println(con);
            String inputLine;
            StringBuffer response2 = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
               
                response2.append(inputLine); 
            }
            
            
            String respuesta = response2.toString();         
            {
            
            if(respuesta.length()>2){
            out.println(respuesta);
            } 
            else {
                out.println("no existe el men");
            }
            }

            in.close();
           
            
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    

}



























































































































































































































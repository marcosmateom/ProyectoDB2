package gio.co.seguros.Citas;

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
import java.net.URI;
import javax.ws.rs.core.Response;
/*import com.google.gson.GsonBuilder;*/



/**
 * Servlet implementation class GetPatient
 */


                


@WebServlet("/verificarPH")
public class verificarPH extends HttpServlet {

    public static int hayono = 0;
    private static final long serialVersionUID = 1L;
    public static String hospitalNum = "1";

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
            String urlH, urlAdd, urlCliente;
            String parDPI = request.getParameter("pId");
            String parServ = request.getParameter("servicioId");
            int parHosp = Integer.parseInt(request.getParameter("hospnum"));
            //parHosp=1;
            //out.println(hayono);
            //out.println(parDPI);            
            //out.println(parServ);
            urlAdd = "http://localhost:8080/proyectoDB2-seguro/AddPatient";
            urlCliente = "http://localhost:8080/proyectoDB2-seguro/restC/cliente/getCliente?dpi="+parDPI;
            
            double DPIcliente = Double.parseDouble(parDPI);
            //CAMBIAR PATHS AQUI
            switch (parHosp){
                case 1:
                        urlH = "http://localhost:8080/proyectoDB2-Hospital1/restP/patient/getPatientDPI?dpi="+DPIcliente;
                    break;
                case 2:
                        urlH = "http://localhost:8080/proyectoDB2-Hospital12/restP/patient/getPatientDPI?dpi="+DPIcliente;
                    break;
                case 3:
                        urlH = "http://localhost:8080/proyectoDB2-Hospital13/restP/patient/getPatientDPI?dpi="+DPIcliente;
                    break;
                default:
                        urlH = "http://localhost:8080/proyectoDB2-Hospital1/restP/patient/getPatientDPI?dpi="+DPIcliente;
                    break;
            }
            
              
            //-----------------------Para obtener el JSON de GetPatient del rest de hospitales-----------------------
            
            URL obj = new URL(urlH);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();           
            int responseCode = con.getResponseCode();
            //out.println("Response code: "+responseCode);            
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            //out.println(con);
            String inputLine;
            StringBuffer response2 = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
               
                response2.append(inputLine); 
            }          
            
            String respuesta = response2.toString(); 
            
            //-----------------------Para obtener el JSON de clientes de la aseguradora-----------------------
            URL obj2 = new URL(urlCliente);
            HttpURLConnection con2 = (HttpURLConnection) obj2.openConnection();           
            int responseCode2 = con2.getResponseCode();
            //out.println("Response code: "+responseCode);            
            BufferedReader in2 = new BufferedReader(
                    new InputStreamReader(con2.getInputStream()));
            //out.println(con);
            String inputLine2;
            StringBuffer response22 = new StringBuffer();
            while ((inputLine2 = in2.readLine()) != null) {
               
                response22.append(inputLine2); 
            }          
            
            String respuesta2 = response22.toString();
            
            {            
            if(respuesta.length()>2){
                //out.println(respuesta);           
                response.sendRedirect("aggregarC_h.jsp?dpi="+parDPI+"&hosp="+parHosp+"&servicioId="+parServ);
            } 
            else {
                //out.println("no existe el men");
                //out.println(response22);
                response.sendRedirect("aggregarP_h.jsp?dpi="+parDPI+"&hosp="+parHosp+"&servicioId="+parServ);
                
                
                
                
            }
            }
            in.close();
           
            
            
            
            
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    

}

































































































































































































































































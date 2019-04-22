package gio.co.hospitales.citas;

import gio.co.hospitales.pacientes.*;
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
 * Servlet implementation class GetCita
 */
@WebServlet("/GetAllCitas")
public class GetAllCitas extends HttpServlet {

    private static final long serialVersionUID = 1L;
    //CAMBIADO POR PRUEBAS
    public static String hospitalNum = "3";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllCitas() {
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
            String urlHosp, numberH;
            
            numberH = request.getParameter("hospNum");
            
            
            
            int numberHosp=Integer.parseInt(numberH);
            
            switch(numberHosp){
                case 1:
                    
                    /*
                    25.66.75.32:8080
                    */
                    urlHosp = "http://25.66.75.32:8080/proyectoDB2-Hospital1/restC/cita/getCita";
                break;
                case 2:
                    urlHosp = "http://25.65.236.60:8080/proyectoDB2-Hospital1/restC/cita/getCita";
                break;
                case 3:
                    urlHosp = "http://25.74.104.162:8080/proyectoDB2-Hospital1/restC/cita/getCita";
                break;     
                default:
                    urlHosp = "http://25.66.75.32:8080/proyectoDB2-Hospital1/restC/cita/getCita";
                break;
                                        
            }
            
            URL obj = new URL(urlHosp);
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
























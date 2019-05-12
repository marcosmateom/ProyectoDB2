package gio.co.hospitales;

import gio.co.seguros.getHospIp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

/**
 * Servlet implementation class DocInfo
 */
@WebServlet("/DocInfo")
public class DocInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
        //LO CAMBIE PARA PRUEBAS
       // private static String hospitalNum = "1";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DocInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	// Generar jsons
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //Obtener # del hospital
            //getInfoCookies(request,response);
            
            //Response info
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            try{
                String hospN = request.getParameter("hosp");
            
                // Send data
                String ipHost = getHospIp.getIP(Integer.parseInt(hospN));
                URL url = new URL("http://"+ipHost+":8080/proyectoDB2-Hospital1/restU/usuarios/getUsuariosTypes?typeId=4");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setDoOutput(true);
            
                // Get the response
                BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                StringBuffer response2 = new StringBuffer();
                while ((line = rd.readLine()) != null) {
                    response2.append(line);
                }
                //JSONObject obj = new JSONObject(response2.toString());           
                out.println(response2.toString());

                rd.close();
               
            }catch(Exception e){
                System.err.println(e);
            }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
        
        /*protected void getInfoCookies(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
            Cookie[] cookiesInf = request.getCookies();
            if(cookiesInf !=null){
                for(Cookie cookie : cookiesInf){
                    if(cookie.getName().equals("hospNum")){
                        hospitalNum = cookie.getValue();
                    }
                }
            }
        }*/
}










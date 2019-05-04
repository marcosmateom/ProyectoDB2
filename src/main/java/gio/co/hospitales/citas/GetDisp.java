package gio.co.hospitales.citas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

/**
 * Servlet implementation class GetCita
 */
@WebServlet("/GetDisp")
public class GetDisp extends HttpServlet {

    private static final long serialVersionUID = 1L;
    //CAMBIADO POR PRUEBAS
    public static String hospitalNum = "3";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDisp() {
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
            String fecha = request.getParameter("fecha");
            String docId = request.getParameter("docId");
            String hospN = request.getParameter("hospN");
            // Construct data
            StringBuilder dataBuilder = new StringBuilder();
            dataBuilder.append(URLEncoder.encode("fecha", "UTF-8")).append('=').append(URLEncoder.encode(fecha, "UTF-8")).append("&").
                    append(URLEncoder.encode("docId", "UTF-8")).append('=').append(URLEncoder.encode(docId, "UTF-8"));
            // Send data
            
            URL url = new URL("http://localhost:8080/proyectoDB2-Hospital1/restC/cita/getDisp");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("GET");
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(dataBuilder.toString());
            wr.flush();

            // Get the response
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            StringBuffer response2 = new StringBuffer();
            while ((line = rd.readLine()) != null) {
                response2.append(line);
            }
            JSONObject obj = new JSONObject(response2.toString());
            int answ = obj.getInt("in");

            if (answ == 1) {
                response.sendRedirect("http://localhost:8080/proyectoDB2-Hospital1/citas_h.jsp?in=1");
            } else {
                response.sendRedirect("http://localhost:8080/proyectoDB2-Hospital1/citas_h.jsp?in=0");
            }
            wr.close();
            rd.close();
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



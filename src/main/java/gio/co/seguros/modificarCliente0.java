/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.seguros;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Projections;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;
import org.bson.types.ObjectId;

@WebServlet("/modificarCliente0")

/**
 *
 * @author C.V
 */
public class modificarCliente0 extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    public modificarCliente0() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
        
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
                //String db_name = "SegurosGio", db_col_name = "Usuarios";
		String  nombre, apellido, identificacion, tipo_poliza, telefono, email, documentoIdentificacion, contacto_emergencia, telefono_contacto_e, _id;
		identificacion = request.getParameter("poliza").toString();
		/*try {*/
			//MongoClient conn = gio.co.seguros.MongoConnectDB.connectMongo();
                        //MongoDatabase db = conn.getDatabase(db_name);
                        //MongoCollection<Document> coll = db.getCollection(db_col_name);
                        MongoCollection<Document> coll = gio.co.seguros.collClientes.collclientes();
                        try {
                        Document document = coll.find(new BasicDBObject("documentoIdentificacion", identificacion)).projection(Projections.fields(Projections.include("nombre","apellido","telefono", "email", "documentoIdentificacion", "contacto_emergencia", "telefono_contacto_e", "tipo_poliza"))).first();
                        
                        //ObjectId id = document.getObjectId("_id");
                        
                        _id = document.getObjectId("_id").toString();
                        nombre = document.getString("nombre");
                        apellido = document.getString("apellido");
                        telefono = document.getString("telefono");
                        tipo_poliza= document.getString("tipo_poliza");
                        email = document.getString("email");
                        documentoIdentificacion = document.getString("documentoIdentificacion"); 
                        contacto_emergencia = document.getString("contacto_emergencia");
                        telefono_contacto_e = document.getString("telefono_contacto_e");
                        

                        
                        response.sendRedirect(String.format("modificarCliente.jsp?nombreS=%s&apellidoS=%s&telefono=%s&tipoPoliza=%s&email=%s&documentoIdentificacion=%s&contacto_emergencia=%s&telefono_contacto_e=%s&id=%s", nombre, apellido, telefono, tipo_poliza, email, documentoIdentificacion, contacto_emergencia, telefono_contacto_e, _id));
                        
                        //request.setAttribute("usuarioS", usuario);
                        /*request.setAttribute("nombreS", nombre);
                        request.setAttribute("apellidoS", apellido);
                        request.setAttribute("passS", pass);
                        request.setAttribute("emailS", email);
                        request.setAttribute("puestoS", puesto);*/
                        //request.getRequestDispatcher("modificarUsuario.jsp").forward(request, response);
                        //RequestDispatcher rd = request.getRequestDispatcher("modificarUsuario.jsp");
                        //rd.forward(request, response);
                        
                        } catch(MongoException | ClassCastException e){
                            e.printStackTrace();
                        }
	}
        
    
}
























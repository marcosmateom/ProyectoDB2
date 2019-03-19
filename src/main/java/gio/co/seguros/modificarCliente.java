/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.seguros;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.bson.Document;
import org.bson.types.ObjectId;

@WebServlet("/modificarCliente")

/**
 *
 * @author C.V
 */
public class modificarCliente extends HttpServlet {
  
    public modificarCliente() {
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
		String  nombre, apellido, _id, tipo_poliza, telefono, email, documentoIdentificacion, contacto_emergencia, telefono_contacto_e;
		_id = request.getParameter("id").toString();
                nombre = request.getParameter("nombre").toString();
                apellido = request.getParameter("apellido").toString();
		tipo_poliza = request.getParameter("tPoliza").toString();
                telefono = request.getParameter("telefono").toString();
                email = request.getParameter("email").toString();
                documentoIdentificacion = request.getParameter("doc").toString();
                contacto_emergencia = request.getParameter("contactoE").toString();
                telefono_contacto_e = request.getParameter("telEm").toString();
		/*try {*/
			//MongoClient conn = gio.co.seguros.MongoConnectDB.connectMongo();
                        //MongoDatabase db = conn.getDatabase(db_name);
                        //MongoCollection<Document> coll = db.getCollection(db_col_name);
                        MongoCollection<Document> coll = gio.co.seguros.collClientes.collclientes();
                        try {
                        
                            BasicDBObject updateFields = new BasicDBObject();
                            updateFields.append("nombre", nombre);
                            updateFields.append("apellido", apellido);
                            updateFields.append("email", email);
                            updateFields.append("telefono", telefono);
                            updateFields.append("tipo_poliza", tipo_poliza);
                            updateFields.append("documentoIdentificacion", documentoIdentificacion);
                            updateFields.append("contacto_emergencia", contacto_emergencia);
                            updateFields.append("telefono_contacto_e", telefono_contacto_e);
                            BasicDBObject searchQuery = new BasicDBObject().append("_id",  new ObjectId(_id)));

                           //coll.replaceOne(searchQuery, updateFields);
                            
                           BasicDBObject setQuery = new BasicDBObject();
                           setQuery.append("$set", updateFields);
                           coll.updateMany(searchQuery, setQuery);
                            //coll.upda
                                                        
                            RequestDispatcher rd = request.getRequestDispatcher("exitoAdminC.jsp");
                            rd.forward(request, response);
                        //puesto = "Admin";
                        } catch(MongoException | ClassCastException e){
                            e.printStackTrace();
                            //log.error("Exception occurred while insert Value using **BasicDBObject** : " + e, e);
                        }
                        
                        //FindIterable<Document> fi = coll.find(eq ("nombre", "Mateo"));
                        //MongoCursor<Document> cursor = fi.iterator();
                        
                        
                        
			/*if(rs.next()) {
				RequestDispatcher rd = request.getRequestDispatcher("page2_h1.jsp");
				rd.forward(request, response);
			}else {
				response.sendRedirect("index.jsp?val=0");
			}
		} /*catch (SQLException e) {
			e.printStackTrace();
		}*/
	}

    
}






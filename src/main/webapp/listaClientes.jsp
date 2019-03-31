<%-- 
    Document   : p
    Created on : Mar 20, 2019, 11:31:05 PM
    Author     : C.V
--%>

<%@page import="org.codehaus.jettison.json.JSONArray"%>
<%@page import="org.bson.Document"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="Agregar Paciente" />
    </jsp:include>
    <!--navbar logged-->

    <body>
        <h1>Listado de Clientes</h1>
        
        <table>
            <thead>
                <tr>
                    <th>tipo de poliza</th>
                    <th>nombre</th>
                    <th>apellido</th>
                    <th>telefono</th>
                    <th>Correo</th>
                    <th>Documento de identificacion</th>
                    <th>Contacto de emergencia</th>
                    <th>Telefono del contacto de emergencia</th>
                    <th>Acciones</th>
                    
                </tr>
            </thead>
            <tbody id="datosClientes">
            </tbody>
        </table>
        
    </body>
    <script src="js/Clientes.js"></script>
</html>



























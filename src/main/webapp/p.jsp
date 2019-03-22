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
        <h1>Hello World!</h1>
        
        <table>
            <thead>
                <tr>
                    
                    <th>Usuario</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Correo</th>
                    <th>Puesto</th>
                    <th>Accion</th>
                    
                </tr>
            </thead>
            <tbody id="dat">
            </tbody>
        </table>
        
    </body>
    <script src="js/Usuarios.js"></script>
</html>


















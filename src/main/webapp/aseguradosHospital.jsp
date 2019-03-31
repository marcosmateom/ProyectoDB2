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
        <jsp:param name="title" value="Citas con seguros" />
    </jsp:include>
    <!--navbar logged-->

    <body>
        <h1>Listado de citas cubiertas por la aseguradora</h1>
        
        <table>
            <thead>
                <tr>
                    
                    <th>No. de Cita</th>
                    <th>Servicio</th>
                    <th>Costo</th>
                    <th>% de cobertura</th>
                    <th>Tipo de seguro</th>
                    
                </tr>
            </thead>
            <tbody id="datosS">
            </tbody>
        </table>
        
    </body>
    <script src="js/aseguradosH.js"></script>
</html>

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
        <jsp:param name="title" value="Listado polizas" />
    </jsp:include>
    <%@ include file="partials/_headerLogged.jsp"%>
    <!--navbar logged-->

    <body>
        <h1>Listado de Polizas</h1>
        
        <table>
            <thead>
                <tr>
                    
                    <th>Nombre Poliza</th>
                    <th>Cobertura</th>
                    
                </tr>
            </thead>
            <tbody id="datosP">
            </tbody>
        </table>
        
    </body>
    <script src="js/Polizas.js"></script>
</html>
























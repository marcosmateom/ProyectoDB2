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
        <jsp:param name="title" value="Lista CLientes" />
    </jsp:include>
    <%@ include file="partials/_headerLogged.jsp"%>
    <!--navbar logged-->
    <body>
        <div class="grid-container">
            <div class="grid-x align-center">
                <div class="cell small-10 medium-12">
                    <h1>Listado de Clientes</h1>
                    <table>
                        <thead>
                            <tr>
                                <th>Tipo de poliza</th>
                                <th>Nombre</th>
                                <th>Telefono</th>
                                <th>Correo</th>
                                <th>Documento de identificacion</th>
                                <th>Contacto de emergencia</th>
                                <th>Telefono del contacto</th>
                                <th>Acciones</th>

                            </tr>
                        </thead>
                        <tbody id="datosClientes">
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
    <script src="js/Clientes.js"></script>
</html>




























<%-- 
    Document   : pacientes_h
    Created on : Mar 10, 2019, 8:36:30 PM
    Author     : migue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!--head-->
    <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="Pacientes" />
    </jsp:include>
    <!--navbar logged-->
    <%@ include file="partials/_headerLogged.jsp"%>
    <body>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Telefono</th>
                    <th>DPI</th>
                    <th>Numero de seguro</th>
                    <th></th>
                </tr>
            </thead>
        </table>
    </body>
</html>

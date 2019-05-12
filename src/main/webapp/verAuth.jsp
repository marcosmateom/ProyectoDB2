<%-- 
    Document   : cita_h
    Created on : Mar 11, 2019, 3:21:42 PM
    Author     : migue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!--head-->
    <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="Historial" />
    </jsp:include>
    <!--navbar logged-->
    <%@ include file="partials/_headerLogged.jsp"%>
    <!--Verify if the user has access-->
    <%@ include file="partials/_getInfo.jsp"%>
    <%        if (rol.equals("1") || (rolNum <= 4)) {

        } else {
            response.sendRedirect("home_h.jsp");
        }
    %>
    <body>
        <div class="grid-container">
            <div class="grid-x align-center">
                <div class="cell small-10 medium-12">
                    <h1>Autorizacion</h1>
                    <table>
                        <tbody>
                            <tr>
                                <td id="hospNum">Hospital: </td>
                                <td id="fecha">Fecha de la cita: </td>
                            </tr>
                            <tr>
                                <td id="nombreP">Asegurado: </td>
                                <td id="dpi">Dpi: </td>
                            </tr>
                            <tr>
                                <td id="serv">Servicio: </td>
                                <td id="costo">Costo: </td>
                            </tr>
                            <tr>
                                <td id="coPago">Copago del Cliente: </td>
                                <td></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="cell small-10 medium-12">
                <a class="button" href="verCliente.jsp?dpi=<%= request.getParameter("dpi")%>" >Atras</a>
                <div id="historialData">
                </div>
            </div>
        </div>
    </div>
</body>
<script src="js/autorizacion/verAuth.js"></script>
</html>







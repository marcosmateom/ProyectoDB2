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
        <jsp:param name="title" value="Ver Historial Cliente" />
    </jsp:include>
    <!--navbar logged-->
    <%@ include file="partials/_headerLogged.jsp"%>
    <!--Verify if the user has access-->
    <%@ include file="partials/_getInfo.jsp"%>
    <body>
        <div class="grid-container">
            <div class="grid-x align-center">
                <div class="cell small-10 medium-12">
                    <h1>Historial Cliente </h1>
                    <a class="button" href="listaClientes.jsp">Atras</a>
                    <table>
                        <thead>
                            <tr>
                                <th>Id Autorizacion</th>
                                <th>Hospital</th>
                                <th>Fecha</th>
                                <th>Servicio</th>
                                <th>Costo</th>
                                <th>CoPago</th>
                                <th>Opciones</th>
                            </tr>
                        </thead>
                        <tbody id="clientData">
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
    <script src="js/historialCliente/historialCliente.js"></script>
</html>


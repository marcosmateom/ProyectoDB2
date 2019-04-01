<%-- 
    Document   : exitoAdminC
    Created on : 03.03.2019, 15:19:07
    Author     : C.V
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="Exito Admin clientes" />
    </jsp:include>
    <%@ include file="partials/_headerLogged.jsp"%>
    <body>
        <div class="grid-container">
            <div class="grid-x align-center">
                <div class="cell small-10 medium-12">
                    <h1>Exito Administracion de clientes!</h1>
                    <a href="listaClientes.jsp" class="button"> Ver Cliente<a/>
                    <br>
                    <a href="clienteNuevo.jsp" class="button"> Registrar Cliente<a/>
                    <br>
                    <a href="modificarCliente0.jsp" class="button"> Modificar Cliente<a/> 
                    <br>
                    <a href="eliminarCliente.jsp" class="button"> Eliminar Cliente<a/>
                </div>
            </div>
        </div>
    </body>
</html>














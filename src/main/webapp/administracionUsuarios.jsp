<%-- 
    Document   : administracionUsuarios
    Created on : Mar 23, 2019, 12:38:13 PM
    Author     : C.V
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="Administracion de usuarios" />
    </jsp:include>
    <%@ include file="partials/_headerLogged.jsp"%>
    <body>
        <h1>Seleccione una accion</h1>
        <a href="listaUsuarios.jsp" class="button">Ver usuarios</a>
        <br>
        <a href="nuevoUsuario.jsp" class="button">Nuevo usuario</a>
        <br>
        <a href="modificarUsuario0.jsp" class="button">Modificar Usuario</a>
        <br>
        <a href="eliminarUsuario.jsp" class="button">Eliminar Usuario</a>
        <br>
        <a href="exitoAdmin.jsp"class="button">Menu Alta Administracion</a>
    </body>
</html>

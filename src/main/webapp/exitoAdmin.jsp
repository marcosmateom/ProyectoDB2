<%-- 
    Document   : exitoAdmin
    Created on : 03.03.2019, 15:07:51
    Author     : C.V
--%>

<!DOCTYPE html>

<html>
    <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="Exito alta admin!" />
    </jsp:include>
    <%@ include file="partials/_headerLogged.jsp"%>
    <body>
        <h1>Exito alta admin!</h1>
        <a href="nuevoUsuario.jsp">Nuevo usuario</a>
        <br>
        <a href="modificarUsuario0.jsp">Modificar Usuario</a>
        <br>
        <a href="eliminarUsuario.jsp">Eliminar Usuario</a>
        <br>
        <a href="tipoSeguro.jsp">administracion de tipo de polizas</a>
        <br>
        <a href="mongoLista.jsp">lista</a>

    </body>
</html>










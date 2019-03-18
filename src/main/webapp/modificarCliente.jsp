<%-- 
    Document   : modificarCliente
    Created on : 11.03.2019, 11:06:14
    Author     : C.V
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
      <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="Modificar Cliente" />
    </jsp:include>
    <body>
        <div class="grid-container">
        <div class="grid-x grid-margin-x align-center">
            <form class="cell small-12 medium-8" action="modificarUsuario" method="post">
                <h1>Se modificara el Cliente  <%= request.getParameter("usuarioS") %> </h1>
                <h4 class="text-center">Ingresa los datos</h4>
                Usuario:<br>
                <input type="hidden" name="usuarioww" value="<%= request.getParameter("usuarioS") %>">                
                <input type="text" name="usuariow" value="<%= request.getParameter("usuarioS") %>" placeholder="Ingrese el nombre de usuario ej. mige97">
                <br> Nombre del Cliente:<br>
                <input type="text" name="nombre" value="<%= request.getParameter("nombreS") %>" placeholder="Ingrese el nombre del empleado">
                <br> Nombre del Cliente:<br>
                <input type="text" name="nombre" value="<%= request.getParameter("apellidoS") %>" placeholder="Ingrese el nombre del empleado">
                <br> Telefono:<br>
                <input type="text" name="telefono" value="<%= request.getParameter("telefono") %>" placeholder="ingrese el numero de telefono del Cliente">
                <br> e-mail:<br>
                <input type="text" name="email" value="" placeholder="ingrese el correo electronico del Cliente">
                <br> documento de identificacion del cliente:<br>
                <input type="text" name="doc" value="" placeholder="Ingrese el numero de identificacion del cliente">
                <br> contacto de emergencia:<br>
                <input type="text" name="contactoE" value="" placeholder="ingreseel nombre de la persona a contactar en caso de emergencia">
                <br> Telefono del contacto de emergencia:<br>
                <input type="text" name="telEm" value="" placeholder="ingrese datos tecnicos del producto">
                <input class="button small-12 cell" type="submit" name="submit" value="Agregar Cliente" />
            </form>
        </div>
    </div>
    </body>
</html>



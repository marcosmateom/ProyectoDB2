<%-- 
    Document   : modificarCliente
    Created on : 11.03.2019, 11:06:14
    Author     : C.V
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
      <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="Modificar cliente" />
    </jsp:include>
    <%@ include file="partials/_headerLogged.jsp"%>
    <body>
        <div class="grid-container">
        <div class="grid-x grid-margin-x align-center">
            <form class="cell small-12 medium-8" action="modificarCliente" method="post">
                <h1>Se modificara el Cliente con la poliza:</h1>
                <h4><%= request.getParameter("id") %></h4>
                <h4 class="text-center">Ingresa los datos</h4>
                <input type="hidden" name="id" value="<%= request.getParameter("id") %>">                
                <br> Nombre del Cliente:<br>
                <input type="text" name="nombre" value="<%= request.getParameter("nombreS") %>" placeholder="Ingrese el nombre del empleado">
                <br> Apellido del Cliente:<br>
                <input type="text" name="apellido" value="<%= request.getParameter("apellidoS") %>" placeholder="Ingrese el nombre del empleado">
                <br> Telefono:<br>
                <input type="text" name="telefono" value="<%= request.getParameter("telefono") %>" placeholder="ingrese el numero de telefono del Cliente">
                <br> e-mail:<br>
                <input type="text" name="email" value="<%= request.getParameter("email") %>" placeholder="ingrese el correo electronico del Cliente">
                <br> tipo de poliza:<br>
                <input type="text" name="tPoliza" value="<%= request.getParameter("tipoPoliza") %>" placeholder="ingrese el correo electronico del Cliente">
                <br> documento de identificacion del cliente:<br>
                <input type="text" name="doc" value="<%= request.getParameter("documentoIdentificacion") %>" placeholder="Ingrese el numero de identificacion del cliente">
                <br> contacto de emergencia:<br>
                <input type="text" name="contactoE" value="<%= request.getParameter("contacto_emergencia") %>" placeholder="ingreseel nombre de la persona a contactar en caso de emergencia">
                <br> Telefono del contacto de emergencia:<br>
                <input type="text" name="telEm" value="<%= request.getParameter("telefono_contacto_e") %>" placeholder="ingrese datos tecnicos del producto">
                <input class="button small-12 cell" type="submit" name="submit" value="Modificar Cliente" />
            </form>
        </div>
    </div>
    </body>
</html>














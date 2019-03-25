<%-- 
    Document   : modificarUsuario0
    Created on : 04.03.2019, 00:32:39
    Author     : C.V
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"
        %>
<!DOCTYPE html>
<%
    String usuario = request.getParameter("usuario");
    if(usuario==null)
    {
        usuario="";
    }
//= request.getParameter("usuario") 
%>
<html>
    <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="Usuario a Modificar" />
    </jsp:include>
    <body>
        <div class="grid-container">
            <div class="grid-x grid-margin-x align-center">
                <form class="cell small-12 medium-8" action="modificarUsuario0" method="post">
                    <h4 class="text-center">Ingrese el usuario a modificar</h4>
                    Usuario:<br>
                    <input type="text" name="usuariow" value="<%= usuario %>" placeholder="Ingrese el nombre de usuario ej. mige97">
                    <br>
                    <input class="button small-12 cell" type="submit" name="submit" value="Modificar Usuario" />
                </form>
            </div>
        </div>
        
    </body>
</html>





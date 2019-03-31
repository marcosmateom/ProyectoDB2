<%-- 
    Document   : tipoSeguro
    Created on : 11.03.2019, 14:22:20
    Author     : C.V
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="administracion de Polizas" />
    </jsp:include>
    <body>
        <h1>Administracion de Polizas</h1>
        <a href="listaPolizas.jsp" class="button">Ver Polizas</a>
        <br>
        <a href="nuevaPoliza.jsp" class="button">Nueva poliza</a>
        <br>
        <a href="modificarPoliza0.jsp" class="button">Modificar poliza</a>
        <br>
        <a href="eliminarPoliza.jsp"class="button">Eliminar poliza</a>
        <br>
        <a href="exitoAdmin.jsp"class="button">Menu Alta Administracion</a>
    </body>
</html>




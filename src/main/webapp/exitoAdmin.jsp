<%-- 
    Document   : exitoAdmin
    Created on : 03.03.2019, 15:07:51
    Author     : C.V
--%>

<!DOCTYPE html>

<html>
    <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="Alta Administracion" />
    </jsp:include>
    <%@ include file="partials/_headerLogged.jsp"%>
    <body>
        <div class="grid-container">
            <div class="grid-x align-center">
                <div class="cell small-10 medium-12">
                    <h1>Exito alta admin!</h1>
                    <a href="administracionUsuarios.jsp"class="button">Administracion de usuarios</a>
                    <br>
                    <a href="administracionPolizas.jsp" class="button">Administracion de polizas</a>
                    <br>
                    <a href="aseguradosHospital.jsp" class="button">Coberturas pagadas</a>
                    <br>
                    <a class="button" href="citas_h.jsp">Ver Citas</a>
                    <br>
                </div>
            </div>
        </div>

    </body>
</html>


















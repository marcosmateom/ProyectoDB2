<%-- 
    Document   : preAgregarCita
    Created on : Apr 10, 2019, 5:28:04 PM
    Author     : manu
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!--head-->
    <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="Nueva Cita" />
    </jsp:include>
    <!--navbar logged-->
    <%@ include file="partials/_headerLogged.jsp"%>
    <!--Verify if the user has access-->
    <%@ include file="partials/_getInfo.jsp"%>
    <%        if (rol.equals("1") || (rolNum <= 3)) {
        } else {
            response.sendRedirect("home_h.jsp");
        }
    %>
    <body>
        <div class="grid-container">
            <div class="grid-x align-center-middle">
                <div class="cell small-10 medium-8">
                    <form class="form" action="verificarPH" method="post">
                        <h4>Seleccione el cliente y el servicio que desea</h4>
                        <!--<input type="hidden" name="hospital" value="</*%= request.getParameter("hospNum") */%>"> -->
                        <label>Cliente: 
                            <select id="clientes" name="cId" required>
                            </select>
                        </label>
                        <label>hospital
                            <select name="hospnum" id="hospnum" required>
                               
                            </select>
                        </label>
                        <label>Servicio: 
                            <select id="serviciosData" name="servicioId" required>
                            </select>
                        </label>
                        <br>
                        <input type="submit" class="cell button medium-8" value="Verificar paciente">
                    </form>
                </div>
            </div>
        </div>
    </body>
    <script src="js/serviceInf.js"></script>
    <script src="js/clienteList.js"></script>
    <script src="js/hospitalesCant.js"></script>
    
</html>






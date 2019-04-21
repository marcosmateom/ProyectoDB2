<%-- 
    Document   : aggregarP_h
    Created on : Mar 12, 2019, 12:41:02 AM
    Author     : migue
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
    <%
        if(rol.equals("1")||(rolNum<=3)){
        }
        else{
            response.sendRedirect("home_h.jsp");
        }
    %>
    <body>
        <div class="grid-container">
            <div class="grid-x align-center-middle">
                <div class="cell small-10 medium-8">
                    <form class="form" action="AddPatient" method="post">
                        <h4>Agregar paciente al hospital <%= request.getParameter("hosp") %></h4>
                        <h5>Confirme los siguientes datos</h5>
                        
                        <input type="hidden" name="id" value="">   
                        <input type="hidden" name="servicioId" value="<%= request.getParameter("servicioId") %>">
                        <input type="hidden" name="hospNum" value="<%= request.getParameter("hosp") %>">
                        <input type="hidden" name="aseguradoraId" value="1">
                        
                        <br> documento de identificacion del cliente:<br>
                        <input type="text" name="doc" value="<%= request.getParameter("dpi") %>" placeholder="">
                        
                        <!--campo se debe autorellenar-->
                        <br> Nombre del Cliente/Paciente:<br>
                        <input type="text" name="nombreC" id="nombreC" value="" placeholder="Ingrese el nombre del empleado">                                                                  
                        
                        <!--campo se debe autorellenar-->
                        <br> Apellido del Cliente:<br>
                        <input type="text" name="apellidoC" id="apellidoC" value="" placeholder="Ingrese el nombre del empleado">
                        
                        <!--campo se debe autorellenar-->
                        <br> Telefono:<br>
                        <input type="text" name="telC" id="telC" value="" placeholder="ingrese el numero de telefono del Cliente">
                                                                       
                        <br> Direccion:<br>
                        <input type="text" name="direccionC" value="" placeholder="ingrese la direccion del paciente">
                        
                        <br> Fecha de nacimiento:<br>
                        <input type="text" name="fNacC" value="" placeholder="ingrese la fecha de nacimiento">
                        
                        <!--campo se debe autorellenar-->
                        <br> Poliza de seguro:<br>
                        <input type="text" name="polizaIdC" id="polizaIdC" value="" placeholder="ingrese la poliza del paciente">
                        
                        <!--campo se debe autorellenar-->
                        <br> Tipo de poliza:<br>
                        <input type="text" name="tipoPolizaC" id="tipoPolizaC" value="" placeholder="ingrese el tipo de poliza del paciente">
                        
                        <label>Doctor / Encargado: 
                            <select id="doctoresData" name="docId" required>
                            </select>
                        </label>
                        
                        
                        
                        
                        
                        
                        
                        
                        <br>
                        <input type="submit" class="cell button medium-8" value="Agregar">
                    </form>
                </div>
            </div>
        </div>
    </body>
    <script type="text/javascript" src="js/docInf.js"></script>
    <script type="text/javascript" src="js/horarioInf.js"></script>
    <script type="text/javascript" src="js/serviciosList.js"></script>
    <script type="text/javascript" src="js/clientInfo.js"></script>
</html>


















































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
                    <form class="form" action="AddCita" method="post">
                        
                        <input type="hidden" name="hospNum" id="hospitalId" value="<%= request.getParameter("hosp") %>">
                        <input type="hidden" name="servicioId" id="serviceId" value="">
                        <input type="hidden" name="pId" id="patientId" value="">
                        
                        <h4>Nueva Cita en hospital <%= request.getParameter("hosp") %></h4>
                        <label>Paciente: 
                            <input type="text" name="pName" id="pacienteC" value="" readonly>
                        </label>
                        <label>DPI: 
                            <input type="text" name="dpi" value="<%= request.getParameter("dpi") %>" readonly>
                        </label>
                        <label>Servicio: 
                            <input type="text" name="servicioId" id="serviceName" value="" readonly>
                        </label>
                        <label>Fecha: 
                            <input id="fecha" type="date" name="fechaCita" required>
                        </label>
                        <label>Doctor / Encargado: 
                            <select id="doctoresData" name="docId" required>
                            </select>
                        </label>                        
                                               
                        <label>Hora: 
                            <select id="horariosData" name="hora" required>
                            </select>
                        </label>
                        <br>
                        <input type="submit" class="cell button medium-8" value="Agregar">
                        
                        <a class="button expanded" href="citas_h.jsp">Cancelar</a>
                        
                    </form>
                </div>
            </div>
        </div>
    </body>
    <script type="text/javascript" src="js/docInf.js"></script>
    <script type="text/javascript" src="js/clientInfoForCita.js"></script>
    <script type="text/javascript" src="js/horarioInf.js"></script>
    <script type="text/javascript" src="js/serviciosList.js"></script>
    <script type="text/javascript" src="js/servicioInfo.js"></script>
    
</html>





































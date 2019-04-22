
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
    
    <body>
        <div class="grid-container">
            <div class="grid-x align-center-middle">
                <div class="cell small-10 medium-8">
                    <form class="form" action="AddPatientFromAseg" method="post">
                        <h4>Agregar paciente al hospital <%= request.getParameter("hosp") %></h4>
                        <h5>Confirme los siguientes datos</h5>
                        
                        <input type="hidden" name="id" value="">   
                        <input type="hidden" name="servicioId" value="<%= request.getParameter("servicioId") %>">
                        <input type="hidden" name="hospNum" value="<%= request.getParameter("hosp") %>">
                        <input type="hidden" name="aseguradoraId" value="1">
                        <input type="hidden" name="asegNum" value="1">
                        
                        <label> documento de identificacion del cliente:
                        <input type="text" name="dpi" value="<%= request.getParameter("dpi") %>" readonly>
                        </label>
                        
                        
                        <!--campo se debe autorellenar-->
                        <label> Nombre del Cliente/Paciente:
                        <input type="text" name="nameP" id="nombreC" value="" >                                                                  
                        </label>
                        
                        <!--campo se debe autorellenar-->
                        <label> Apellido del Cliente:
                        <input type="text" name="lastNameP" id="apellidoC" value="" >
                        </label>
                        
                        <!--campo se debe autorellenar-->
                        <label> Telefono:
                        <input type="text" name="tel" id="telC" value="" >
                        </label>
                        
                        <label>Direccion:
                        <input type="text" name="dir" value="" placeholder="ingrese la direccion del paciente">
                        </label>
                            
                        <label> Fecha de nacimiento:
                        <input type="date" name="bDate" value="" placeholder="ingrese la fecha de nacimiento">
                        </label>
                        
                        
                        <!--campo se debe autorellenar-->
                        <label>Poliza de seguro:
                        <input type="text" name="segNum" id="polizaIdC" value="<%= request.getParameter("dpi") %>" readonly>
                        </label>
                        
                        <!--campo se debe autorellenar-->
                        <label>Tipo de poliza:
                        <input type="text" name="tipoPoliza" id="tipoPolizaC" value="" readonly>
                        </label>
                        <input type="hidden" name="asegType" value="1">
                        
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
    
    <script type="text/javascript" src="js/clientInfo.js"></script>
</html>












































































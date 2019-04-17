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
        <jsp:param name="title" value="Modificar Cita" />
    </jsp:include>
    <!--navbar logged-->
    
    <body>
        <div class="grid-container">
            <div class="grid-x align-center-middle">
                <div class="cell small-10 medium-8">
                    <form class="form" action="agregarCita_h.jsp" method="post">
                        <h4>Seleccione el cliente y el servicio que desea</h4>
                        
                        <label>Paciente: 
                            <select id="patients" name="pId" required>
                            </select>
                        </label>
                    
                        
                        <label>Servicio: 
                            <select id="serviciosData" name="servicioId" required>
                            </select>
                        </label>
                        
                        <br>
                        <input type="submit" class="cell button medium-8" value="Modificar">
                    </form>
                </div>
            </div>
        </div>
    </body>
    <script src="js/docInf.js"></script>
    <script src="js/serviciosList.js"></script>
    <script src="js/citasModInf.js"></script>
    <script src="js/patientsList.js"></script>
    <script src="js/horarioInf.js"></script>
</html>

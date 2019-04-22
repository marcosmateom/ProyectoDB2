<%-- 
    Document   : exitoAdmin
    Created on : 03.03.2019, 15:07:51
    Author     : migue
--%>

<!DOCTYPE html>

<html>
    <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="Ver Autorizacion" />
    </jsp:include>
    <%@ include file="partials/_headerLogged.jsp"%>
    <body>
        <div class="grid-container">
            <div class="grid-x align-center">
                <div class="cell small-10 medium-12">
                    <h1>Autorizacion No. <%= request.getParameter("idAuth")%>:</h1>
                    <table>
                        <thead><tr><td><u>Datos Autorizacion</u></td></tr></thead>
                        <tbody>
                            <tr><td id="authNum"><strong>Autorizacion No. </strong></td></tr>
                            <tr><td id="hospNum"><strong>Hospital: </strong></td></tr>
                            <tr><td id="citaId"><strong>Numero de Cita: </strong></td></tr>
                            <tr><td id="fecha"><strong>Fecha: </strong></td></tr>
                            <tr><td id="serv"><strong>Servicio: </strong></td></tr>
                            <tr><td id="monto"><strong>Monto: </strong></td></tr>
                            <tr><td id="porcentaje"><strong>Porcentaje de Cobertura: </strong></td></tr>
                            <tr><td id="totalC"><strong>Pago seguro: </strong>Q. </td></tr>
                            <tr><td id="totalP"><strong>Deducible: </strong>Q. </td></tr>
                        </tbody>
                    </table>
                    <table>
                        <thead><tr><td><u>Datos Cliente</u></td></tr></thead>
                        <tbody>
                            <tr><td id="nombreP"><strong>Nombre Completo: </strong></td></tr>
                            <tr><td id="dpi"><strong>DPI: </strong></td></tr>
                            <tr><td id="polizaP"><strong>Tipo De Poliza: </strong></td></tr>
                            <tr><td id="cobN"><strong>Cobertura: </strong></td></tr>
                            <tr><td id="tel"><strong>Telefono: </strong></td></tr>
                            <tr><td id="email"><strong>E-mail: </strong></td></tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
    <script src="js/autorizacion/auths.js"></script>
</html>
<%-- 
    Document   : exitoAdmin
    Created on : 03.03.2019, 15:07:51
    Author     : C.V
--%>

<!DOCTYPE html>

<html>
    <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="Administracion Autorizaciones" />
    </jsp:include>
    <%@ include file="partials/_headerLogged.jsp"%>
    <body>
        <div class="grid-container">
            <div class="grid-x align-center">
                <div class="cell small-10 medium-12">
                    <h1>Autorizaciones:</h1>
                    <table>
                        <thead>
                            <tr>
                                <th>ID Autorizacion</th>
                                <th>DPI</th>
                                <th>Hospital</th>
                                <th>Servicio</th>
                                <th>Fecha de la Cita</th>
                                <th>Estado</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody id="authData">
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
    <script src="js/autorizacion/authList.js"></script>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<<<<<<< HEAD
    <jsp:include page="partials/_head.jsp">
        <jsp:param name="title" value="Portal de hospitales" />
    </jsp:include>
    <body>

        <h1>Seleccione un establecimiento</h1>
        <a href="login_h.jsp">Hospitales</a><br>
        <a href="login_s1.jsp">Seguros</a>
        

    </body>
=======
<head>
<meta charset="ISO-8859-1">
<title>Bienvenido a Gio Seguros</title>
</head>
<body>
    <h1>Gio Seguros S.A</h1>
    <form action="ValidateMongo" method="post">
        <input type="text" name="user_id" placeholder="User ID"/><br>
        <input type="password" name="password" placeholder="Password"/><br>
        <input type="submit" value="Login"/>
    </form>
</body>
>>>>>>> mateo
</html>






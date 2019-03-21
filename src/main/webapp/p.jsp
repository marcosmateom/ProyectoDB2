<%-- 
    Document   : p
    Created on : Mar 20, 2019, 11:31:05 PM
    Author     : C.V
--%>

<%@page import="org.bson.Document"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <%
  ArrayList<Document> clientes=(ArrayList<Document>) request.getAttribute("clientes"); 
  for (Document post: clientes) {   
%>
  <tr>
      <td><%=post%></td>
  <br>
   </tr>
<%}%>
        
    </body>
</html>

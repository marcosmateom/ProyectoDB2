<%-- 
    Document   : p
    Created on : Mar 20, 2019, 11:31:05 PM
    Author     : C.V
--%>

<%@page import="org.codehaus.jettison.json.JSONArray"%>
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
            int i;
            int j=0;
                            int num = clientes.size();
                            JSONArray arr = new JSONArray();
                            for(i=0; i<clientes.size(); i++){
                                String cliente = clientes.get(i).toJson();
                                arr.put(cliente);
                            }
        %>
        <tr>
            <td><%out.println(arr);%></td>
        <br>
         </tr>
<%%>
        
    </body>
</html>









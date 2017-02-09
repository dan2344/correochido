<%-- 
    Document   : recibe
    Created on : 2/02/2017, 10:27:58 AM
    Author     : Alumno
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String k = request.getParameter("validador") == null ? "" : request.getParameter("validador");


    String mensaje = "";
        BD.cDatos ejecuta = new BD.cDatos();

    try {


        ejecuta.conectar();
        ResultSet valida = ejecuta.consulta("call cambia('" + Integer.parseInt(k) + "');");

        ejecuta.cierraConexion();
    } catch (Exception e) {

        mensaje = e.getMessage();
    }

    response.sendRedirect("envia.jsp?envia=" + mensaje);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <h1><%=k%></h1>
    </head>
    <body>
       
    </body>
</html>

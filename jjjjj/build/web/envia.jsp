<%-- 
    Document   : envia
    Created on : 2/02/2017, 10:27:48 AM
    Author     : Alumno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

    
    String respuesta="";
    String mail=""; 
    
     String urlRegistroValido = "?validador="+"1";

      String contenido = "<h1>¡Estás a un paso de formar parte de nuestra comunidad!</h1>";
       contenido+="Para validar tu registro da clic <a href=\"http://localhost:8080/jjjjj/recibe.jsp" + urlRegistroValido+"\">aqui</a> para confirmar ";
      
    
    
    extras.cMail enviar= new extras.cMail();
    
    String recibido=request.getParameter("envia")== null ? "" : request.getParameter("envia");
   
    if(enviar.mandaMAil(recibido, "Hola Dan", contenido)){
        respuesta="enviado";
    }else{
        respuesta="no enviado";
    }
   


%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%=respuesta%>
        <form method="post" action="envia.jsp">
            
            <input type="escribe tu correo" name="envia" placeholder="escribe algo"/>
                   
            <input type="submit">
        </form>
    </body>
</html>

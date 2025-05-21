<%@ page import="java.util.*" %>
<%@ page import="org.apache.commons.fileupload.*" %>
<%@ page import="org.apache.commons.fileupload.disk.*" %>
<%@ page import="org.apache.commons.fileupload.servlet.*" %>
<%@ page import="org.apache.commons.io.*" %>
<%@ page import="java.io.*" %>
<%@page import="Entity.Email"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado correo</title>
    </head>
    <body>

        <%
            /*Email email = new Email();
            
            //String de = request.getParameter("de");
            //String clave = request.getParameter("clave");
            String para = request.getParameter("para");
            String mensaje = request.getParameter("mensaje");
            String asunto = request.getParameter("asunto");
            
            String [] direcciones = {"", "", "", ""};
           //boolean resultado = email.envioCorreo(para, mensaje, asunto);
            //boolean resultado = email.enviarCorreo(de, clave, direcciones, mensaje, asunto);
            boolean resultado = email.envioCorreo(para, mensaje, asunto);
            
            if (resultado) {
                out.print("Correo enviado"+"\n\n"+"<a href='Email.jsp'>Volver a email</a>");
            }else {
                out.print("Correo no enviado"+"\n\n"+"<a href='Email.jsp'>Volver a email</a>");
            }*/

            Email email = new Email();

           /* String De = request.getParameter("De");
            String Clave = request.getParameter("Clave");*/
            String para = request.getParameter("Para");
            String asunto = request.getParameter("Asunto");
            String mensaje = request.getParameter("Mensaje");
            /*String toAddress = request.getParameter("toAddress");
            String filename = request.getParameter("filename");*/

            
                String[] mails = {";",";",";",";"};
                /*boolean resultado = email.envioCorreo(De, Clave, direcciones, Asunto,Mensaje);*/
             
            
            boolean resultado =email.envioCorreo(para, mensaje, asunto);

            if (resultado) {
                out.print("Correo enviado" + "\n\n" + "<a href='Email.xhtml'>Volver a email</a>");
            } else {
                out.print("Correo no enviado" + "\n\n" + "<a href='Email.xhtml'>Volver a email</a>");
            }

        %>


    </body>
</html>

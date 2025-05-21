/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Julian Camilo
 */
public class Email {
    
    public boolean envioCorreo( String para, String mensaje, String asunto){
        
        boolean enviado = false;
        
        final String de = "braintecprosi@gmail.com";// correo desde el que se van a enviar
        final String clave = "braintec12345";// contraseña
        
        String[] mails;
        mails = para.split(";");
        String host = "smtp.gmail.com";

        Properties props = new Properties();

        // Defining properties
        props.put("mail.smtp.host", host);
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.user", de);
        props.put("mail.password", clave);
        props.put("mail.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        // Authorized the Session object.
        Session sesion = Session.getInstance(props, new javax.mail.Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(de, clave);
            }

        });
        
        try {

            MimeMessage message = new MimeMessage(sesion);
            message.setFrom(new InternetAddress(de));

            for (int i = 0; i < mails.length; i++) {
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(mails[i]));
            }
            
            message.setSubject(asunto);
            message.setText(mensaje);
            
            Transport transport = sesion.getTransport("smtp");
            transport.connect(host,de,clave);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            enviado = true;

        } catch(Exception e){
            e.printStackTrace();
        }
        
        return enviado;
    }
}
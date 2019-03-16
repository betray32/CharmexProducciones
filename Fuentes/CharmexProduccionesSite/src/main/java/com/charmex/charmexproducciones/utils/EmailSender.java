package com.charmex.charmexproducciones.utils;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Como que no quiere la cosa se uso http://www.simplejavamail.org/#/features
 *
 * @author Camilo
 */
public class EmailSender {

    public boolean enviarEmail(String nombre, String email_cliente, String mensaje, String fono) {

        System.out.println("Se inicia una solicitud para enviar un email");
        System.out.println("Leyendo parametros solicitados:");
        System.out.println("Nombre Usuario: " + nombre);
        System.out.println("Email Solicitante: " + email_cliente);
        System.out.println("Mensaje: " + mensaje);
        
        String telefono = "No especificado";
        
        if ( !"".equals(fono) ) {
            telefono = fono;
        } 
        
        final String username = ConstantesEmail.EMAIL_USUARIO;
        final String password = ConstantesEmail.EMAIL_CLAVE;

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email_cliente));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(ConstantesEmail.EMAIL_USUARIO));
            message.setSubject("Contacto cliente nombre: " + nombre);
            message.setText(mensaje + "\n\n Datos cliente: Email: " + email_cliente + " - Telefono: " + telefono);

            Transport.send(message);

            System.out.println("Email Enviado correctamente");
            return true;

        } catch (MessagingException e) {
            System.err.println("Ha ocurrido un error al enviar el email solicitado por el usuario, Error: " + e.getMessage());
        }
        
        return false;

    }

}

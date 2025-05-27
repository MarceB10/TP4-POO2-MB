package Ejercicio2.servicio;

import Ejercicio2.modelo.EmailService;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import java.util.Properties;

public class MailTrapEmailService  implements EmailService {
    private static final String HOST  = "sandbox.smtp.mailtrap.io";
    private static final String PORT = "2525";
    private static final String USER = "16b2d278863398";
    private static final String PASSWORD = "8b65368450f2d6";
    
    public String mensaje = "¡Feliz cumpleaños!";
    
    public MailTrapEmailService() {
    }

    // destinatario es el mail
    public void enviarSaludoCumple(String destinatario, String nombre) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", HOST);
        props.put("mail.smtp.port", PORT);

        Session sesion = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USER, PASSWORD);
            }
        });
        try {
            Message message = new MimeMessage(sesion);
            message.setFrom(new InternetAddress(USER));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject(mensaje);
            message.setText(mensaje + nombre + "!");

            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

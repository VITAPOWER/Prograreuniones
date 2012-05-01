/*
 *Proyecto: Programa Reuniones para Ramon Brena
 * 
 *Alumnos/Autores que participaron:
 *Adrián M Morales 615525                                                   
 *Eder Ramírez 796598
 *Daniel Sánchez 617763
 *Carolina Flores 617680
 * 
 *Materia: Proyecto Integrador 9nvo semestre
 *Profesor: Dr.Lorena Gomez y Dr.Juan Carlos Lavariega
 *
 * Nombre de archivo: Mail.java
 * Fecha Ultima Modificacion: Abril, 30, 2012
 * 
 * Descripcion: clase para mandar correos electronicos.
 */

/*Paquete:
 * Nombrar paquete al que pertenece el archivo.
 */
package action;
/*
 * Librerias: Importar librerias utilizadas
 */
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

/*
 * Inicio de la clase: 
 * Descripcion: esta clase permite el envio de correos electronicos.
 */

public class Mail {

    public void SendEmail(String to, String from, String host, String subject, String body) {
        // to: Recipient's email ID needs to be mentioned.
        // from: Sender's email ID needs to be mentioned
        // String host = "localhost"; Assuming you are sending email from localhost

        // Get system properties
        Properties properties = System.getProperties();

        final String username = "progareuniones@gmail.com";
        final String password = "123pass456";

        // Setup mail server
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");

        // Session Object

        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {

                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));
            //message.setRecipients(Message.RecipientType.TO,
            //			InternetAddress.parse("to-email@gmail.com"));

            // Set Subject: header field
            message.setSubject(subject);

            // Now set the actual message
            message.setText(body);

            // Send message
            Transport.send(message);
            //System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
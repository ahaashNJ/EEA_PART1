package com.example.eea_part1.Service;

import org.springframework.stereotype.Service;


import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

@Service
public class EmailService {

    private final String instituteTimetableEmail = "timetablesystem69@gmail.com";
    private final String password = "angrybirds11";
    private final String Host = "smtp.gmail.com";
    private Properties property;
    private Session session;
    private Authenticator theAuthenticator;
    Properties prop;

    private static EmailService email = new EmailService();

    public EmailService() {
        prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", true);
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");


        theAuthenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(instituteTimetableEmail, password);
            }
        };

        session = Session.getDefaultInstance(prop, theAuthenticator);
    }

    public void EmailToUser(String receiverEmail) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(instituteTimetableEmail));
            message.setRecipients(
                    Message.RecipientType.TO, InternetAddress.parse(receiverEmail));
            message.setSubject("----------" +
                    "Enrolled Successfully!" +
                    "----------");

            String messageBody = "Dear User,<br /><br />" +

                    "Welcome! You have successfully been registered to our institute's timetable system. <br /><br />" +
                    "You'll be able to view your modules, your account, and the current day's timetable. <br /><br />" +
                    "Your default password is 'Aa12345'.<br /><br />" +
                    "You can now login with the provided email and the default password.<br /><br />"+
                    "Remember to update the default password.<br /><br />" +
                    "<br /><br /> Best Regards," +
                    "Admin";


            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            Multipart multi= new MimeMultipart();
            BodyPart messageBodyPart = new MimeBodyPart();
            String fileName="../../main/webapp/WEB-INF/Webpages/Message.html";
            DataSource source= new FileDataSource(fileName);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(fileName);
            multi.addBodyPart(messageBodyPart);

            mimeBodyPart.setContent(messageBody, "text/html");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            message.setContent(multipart);
            Transport.send(message);

        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error Sending the email");
        }
    }
}

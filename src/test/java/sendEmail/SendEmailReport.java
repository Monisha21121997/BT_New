package sendEmail;

import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.util.Date;
import java.util.Properties;

public class SendEmailReport {
    public static void main(String[] args) {
        System.out.println("::Starting Email Sending Process::");
        //provide recipient's email ID
        String to = "pranjal.yadav@axeno.co";
        //provide sender's email ID
        String from = "pranjal.yadav.argildx@gmail.com";
        final String username = "pranjal.yadav.argildx@gmail.com";
        final String password = "jzxiibtuwuoicphe";
        String host = "smtp.gmail.com";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "465");
        Date date = new Date();
        //create the Session object
        Session session = Session.getInstance(props,
                new jakarta.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            //create a MimeMessage object
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            //set email subject field
            message.setSubject("Test Execution Report | Completed on "+date.toString());
            //Add Attachment
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Please find the attached Test Execution Report");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();
            String fileName = System.getProperty("user.dir")+"/target/ExecutionReports/Report.html";
            DataSource source = new FileDataSource(fileName);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName("Report.html");
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);
            //send the email message
            Transport.send(message);
            System.out.println("Email Message Sent Successfully");
        }
        catch (MessagingException e) {
            throw new RuntimeException("Unable to send email--> "+e);
        }
    }
}

package utils;

import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import managers.FileReaderManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.Properties;

/**
 * This class is called from maven to send the email It attaches the report file in a mail sends it
 * is uses Java Jakarta Email API
 */
public class SendEmailReport {

  static Logger log = LogManager.getLogger(SendEmailReport.class);

  public static void main(String[] args) {
    log.info("-----------------------------------------------------------------------------");
    log.info("::::::::::::::::::::: Starting Email Send Process :::::::::::::::::::::");
    log.info("-----------------------------------------------------------------------------");

    //Setting the Recipient's email ID
    String to = FileReaderManager.getInstance().getConfigFileReader().getToEmailAddress();

    //Setting the Sender's email ID
    String from = FileReaderManager.getInstance().getConfigFileReader().getFromEmailAddress();

    //Setting the Sender's username
    final String username = FileReaderManager.getInstance().getConfigFileReader()
        .getFromEmailAddress();

    //Setting the Sender's password
    final String password = FileReaderManager.getInstance().getConfigFileReader()
        .getFromEmailAddressPassword();

    //Email host details
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
      message.setSubject("Test Execution Report | Completed on " + date.toString());

      //Add Attachment
      BodyPart messageBodyPart = new MimeBodyPart();
      messageBodyPart.setText("PFA the Test Execution Report HTML File");
      Multipart multipart = new MimeMultipart();
      multipart.addBodyPart(messageBodyPart);
      messageBodyPart = new MimeBodyPart();
      String fileName = System.getProperty("user.dir") + "/target/ExecutionReports/Report.html";
      DataSource source = new FileDataSource(fileName);
      messageBodyPart.setDataHandler(new DataHandler(source));
      messageBodyPart.setFileName("Report.html");
      multipart.addBodyPart(messageBodyPart);
      message.setContent(multipart);

      //send the email message
      Transport.send(message);
      log.info("-----------------------------------------------------------------------------");
      log.info("::::::::::::::::::::: Email Message Sent Successfully :::::::::::::::::::::");
      log.info("-----------------------------------------------------------------------------");
    } catch (MessagingException e) {
      throw new RuntimeException("<----------- Unable to send email -----------> " + e);
    }
  }
}

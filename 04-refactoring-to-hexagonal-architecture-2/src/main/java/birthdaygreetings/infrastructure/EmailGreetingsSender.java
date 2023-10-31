package birthdaygreetings.infrastructure;

import birthdaygreetings.core.GreetingMessage;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;

public class EmailGreetingsSender {

    private String smtpHost;
    private int smtpPort;
    private String sender;

    public EmailGreetingsSender(String smtpHost, int smtpPort, String sender) {
        this.smtpHost = smtpHost;
        this.smtpPort = smtpPort;
        this.sender = sender;
    }

    public void send(List<GreetingMessage> messages) throws MessagingException {
        for (GreetingMessage message : messages) {
            String recipient = message.to();
            String body = message.text();
            String subject = message.subject();
            sendMessage(subject, body, recipient);
        }
    }

    protected void sendMessage(Message msg) throws MessagingException {
        Transport.send(msg);
    }

    private void sendMessage(String subject, String body, String recipient)
        throws MessagingException {
        // Create a mail session
        java.util.Properties props = new java.util.Properties();
        props.put("mail.smtp.host", this.smtpHost);
        props.put("mail.smtp.port", "" + this.smtpPort);
        Session session = Session.getDefaultInstance(props, null);

        // Construct the message
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(this.sender));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(
            recipient));
        msg.setSubject(subject);
        msg.setText(body);

        // Send the message
        sendMessage(msg);
    }

}

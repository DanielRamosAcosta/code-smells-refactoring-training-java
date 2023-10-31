package birthdaygreetings.infrastructure;

import birthdaygreetings.core.CannotSendGreetingsMessageException;
import birthdaygreetings.core.GreetingMessage;
import birthdaygreetings.core.GreetingsSender;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;

public class EmailGreetingsSender implements GreetingsSender {

    private final String smtpHost;
    private final int smtpPort;
    private final String sender;

    public EmailGreetingsSender(String smtpHost, int smtpPort, String sender) {
        this.smtpHost = smtpHost;
        this.smtpPort = smtpPort;
        this.sender = sender;
    }

    @Override
    public void send(List<GreetingMessage> messages) {
        for (GreetingMessage message : messages) {
            sendMessage(message);
        }
    }


    private void sendMessage(GreetingMessage message) {
        try {
            Session session = createMailSession();

            Message msg = constructMessage(message, session);

            sendMessage(msg);
        } catch (MessagingException e) {
            throw new CannotSendGreetingsMessageException(e);
        }
    }

    private Message constructMessage(GreetingMessage message, Session session) throws MessagingException {
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(this.sender));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(message.to()));
        msg.setSubject(message.subject());
        msg.setText(message.text());
        return msg;
    }

    private Session createMailSession() {
        java.util.Properties props = new java.util.Properties();
        props.put("mail.smtp.host", this.smtpHost);
        props.put("mail.smtp.port", "" + this.smtpPort);
        return Session.getDefaultInstance(props, null);
    }

    protected void sendMessage(Message msg) throws MessagingException {
        Transport.send(msg);
    }

}

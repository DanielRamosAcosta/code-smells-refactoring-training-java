package birthdaygreetings.infrastructure;

import birthdaygreetings.core.CannotSendGreetingsMessageException;
import birthdaygreetings.core.Employee;
import birthdaygreetings.core.GreetingMessage;
import org.junit.jupiter.api.Test;

import javax.mail.Message;
import javax.mail.MessagingException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static test.birthdaygreetings.helpers.OurDateFactory.ourDateFromString;

class EmailGreetingsSenderTest {
    private static final int SMTP_PORT = 25;
    private String SMTP_HOST = "localhost";
    private static final String FROM = "sender@here.com";
    @Test
    void throws_exception_when_email_isinvalid() throws Exception {
        List<Employee> employees = List.of(new Employee("foo", "bar", ourDateFromString("1990/01/31"), "a@b.c"));
        List<GreetingMessage> messages  = GreetingMessage.generateForSome(employees);
        EmailGreetingsSender greetingsSender = new EmailGreetingsSender(SMTP_HOST, SMTP_PORT, FROM){
            @Override
            protected void sendMessage(Message msg) throws MessagingException {
                throw new MessagingException();
            }
        };
        assertThrows(CannotSendGreetingsMessageException.class, () -> greetingsSender.send(messages));
    }
}
package test.birthdaygreetings.application;

import birthdaygreetings.application.BirthdayService;
import birthdaygreetings.core.GreetingsSender;
import birthdaygreetings.core.OurDate;
import birthdaygreetings.infrastructure.EmailGreetingsSender;
import birthdaygreetings.infrastructure.repositories.FileEmployeesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.mail.Message;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static test.birthdaygreetings.helpers.OurDateFactory.ourDateFromString;

class BirthdayServiceAcceptanceTest {

    private static final int SMTP_PORT = 25;
    private String SMTP_HOST = "localhost";
    private static final String FROM = "sender@here.com";
    private List<Message> messagesSent;
    private BirthdayService service;
    private static final String EMPLOYEES_FILE_PATH = "src/test/resources/employee_data.txt";

    @BeforeEach
    public void setUp() {
        messagesSent = new ArrayList<>();

        GreetingsSender greetingsSender = new EmailGreetingsSender(SMTP_HOST, SMTP_PORT, FROM){
            @Override
            public void sendMessage(Message msg) {
                messagesSent.add(msg);
            }
        };
        service = new BirthdayService(new FileEmployeesRepository(EMPLOYEES_FILE_PATH), greetingsSender);
    }

    @Test
    void baseScenario() throws Exception {
        OurDate today = ourDateFromString("2008/10/08");

        service.sendGreetings(today);

        assertEquals(1, messagesSent.size(), "message not sent?");
        Message message = messagesSent.get(0);
        assertEquals("Happy Birthday, dear John!", message.getContent());
        assertEquals("Happy Birthday!", message.getSubject());
        assertEquals(1, message.getAllRecipients().length);
        assertEquals("john.doe@foobar.com", message.getAllRecipients()[0].toString());
    }

    @Test
    void willNotSendEmailsWhenNobodysBirthday() throws Exception {
        OurDate today = ourDateFromString("2008/01/01");

        service.sendGreetings(today);

        assertEquals(0, messagesSent.size());
    }
}

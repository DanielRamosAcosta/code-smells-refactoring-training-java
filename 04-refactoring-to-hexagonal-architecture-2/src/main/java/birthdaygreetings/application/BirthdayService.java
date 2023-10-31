package birthdaygreetings.application;

import birthdaygreetings.core.Employee;
import birthdaygreetings.core.EmployeesRepository;
import birthdaygreetings.core.GreetingMessage;
import birthdaygreetings.core.OurDate;
import birthdaygreetings.infrastructure.EmailGreetingsSender;

import javax.mail.MessagingException;
import java.util.List;

public class BirthdayService {

    private final EmailGreetingsSender greetingsSender;
    private EmployeesRepository employeesRepository;

    public BirthdayService(EmployeesRepository employeesRepository, EmailGreetingsSender greetingsSender) {
        this.employeesRepository = employeesRepository;
        this.greetingsSender = greetingsSender;
    }

    public void sendGreetings(OurDate date, String smtpHost, int smtpPort, String sender) throws MessagingException {
        greetingsSender.send(greetingMessagesFor(employeesHavingBirthday(date)),smtpHost, smtpPort, sender);
    }

    private List<GreetingMessage> greetingMessagesFor(List<Employee> employees) {
        return GreetingMessage.generateForSome(employees);
    }

    private List<Employee> employeesHavingBirthday(OurDate today) {
        return employeesRepository.whoseBirthdayIs(today);
    }

}

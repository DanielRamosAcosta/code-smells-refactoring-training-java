package birthdaygreetings.application;

import birthdaygreetings.core.*;

import java.util.List;

public class BirthdayService {

    private final GreetingsSender greetingsSender;
    private final EmployeesRepository employeesRepository;

    public BirthdayService(EmployeesRepository employeesRepository, GreetingsSender greetingsSender) {
        this.employeesRepository = employeesRepository;
        this.greetingsSender = greetingsSender;
    }

    public void sendGreetings(OurDate date) {
        greetingsSender.send(greetingMessagesFor(employeesHavingBirthday(date)));
    }

    private List<GreetingMessage> greetingMessagesFor(List<Employee> employees) {
        return GreetingMessage.generateForSome(employees);
    }

    private List<Employee> employeesHavingBirthday(OurDate today) {
        return employeesRepository.whoseBirthdayIs(today);
    }

}

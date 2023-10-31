package birthdaygreetings.core;

public class CannotSendGreetingsMessageException extends RuntimeException {

    public CannotSendGreetingsMessageException(Exception exception) {
        super(exception);
    }

}

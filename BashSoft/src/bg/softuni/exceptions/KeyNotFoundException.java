package bg.softuni.exceptions;

public class KeyNotFoundException extends RuntimeException{

    private static final String NON_EXISTING_COURSE = "Course does not exist.";

    public KeyNotFoundException() {
        super(NON_EXISTING_COURSE);
    }

    public KeyNotFoundException(String message) {
        super(message);
    }
}

package bg.softuni.exceptions;

public class NumberOutOfRangeException extends RuntimeException{

    private static final String INVALID_NUMBER_OF_SCORES =
            "The number of scores for the given course is greater than the possible.";

    public NumberOutOfRangeException() {
        super(INVALID_NUMBER_OF_SCORES);
    }

    public NumberOutOfRangeException(String message) {
        super(message);
    }
}

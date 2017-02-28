package bg.softuni.exceptions;

public class InitializedException extends RuntimeException{

    private static final String DATA_ALREADY_INITIALIZED = "Data is already initialized.";

    public InitializedException() {
        super(DATA_ALREADY_INITIALIZED);
    }

    public InitializedException(String message) {
        super(message);
    }
}

package view;

public class IllegalUserInputException extends RuntimeException {

    public IllegalUserInputException() {
    }

    public IllegalUserInputException(String message) {
        super(message);
    }
}

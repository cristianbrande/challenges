package solution;

class InvalidInputException extends RuntimeException {
    private final static String ERROR_MESSAGE = "Invalid Morse Code Or Spacing";

    InvalidInputException() {
        super(ERROR_MESSAGE);
    }
}

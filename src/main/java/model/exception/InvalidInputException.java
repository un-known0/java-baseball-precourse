package model.exception;

public class InvalidInputException extends UserException {

    public InvalidInputException(InputErrorCode code) {
        super(code);
    }
}

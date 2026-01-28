package model.exception;

public abstract class UserException extends RuntimeException {

    private final InputErrorCode inputErrorCode;

    public UserException(InputErrorCode code) {
        super(code.getMessage());
        this.inputErrorCode = code;
    }

    public InputErrorCode getErrorCode() {
        return inputErrorCode;
    }

    @Override
    public String getMessage(){
        return inputErrorCode.getMessage();
    }
}

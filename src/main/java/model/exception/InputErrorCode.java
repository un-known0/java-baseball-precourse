package model.exception;

public enum InputErrorCode {

    // 입력 관련
    INVALID_INPUT_FORMAT("숫자만 입력할 수 있습니다."),
    INVALID_INPUT_EMPTY("입력값이 비어있습니다."),
    INVALID_RESTART_INPUT("1 또는 2만 입력할 수 있습니다."),

    // 중복 관련
    DUPLICATE_NUMBER("중복된 숫자가 있습니다."),

    // 길이 관련
    INVALID_LENGTH("입력 길이가 올바르지 않습니다.")

    ;

    private final String message;

    InputErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

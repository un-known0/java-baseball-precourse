package model;

import model.exception.InputErrorCode;
import model.exception.InvalidInputException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    private final InputValidator validator = new InputValidator();

    @Test
    @DisplayName("parseToNumbers: 숫자 문자열 파싱")
    void parseToNumbers_parsesDigits() {
        List<Integer> numbers = validator.parseToNumbers("123", 1, 9, 3);

        assertThat(numbers).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("parseToNumbers: 앞뒤 공백 제거")
    void parseToNumbers_trimsInput() {
        List<Integer> numbers = validator.parseToNumbers(" 123 ", 1, 9, 3);

        assertThat(numbers).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("parseToNumbers: null이면 예외")
    void parseToNumbers_throwsOnNull() {
        assertInvalidInput(() -> validator.parseToNumbers(null, 1, 9, 3), InputErrorCode.INVALID_INPUT_EMPTY);
    }

    @Test
    @DisplayName("parseToNumbers: 공백/빈 문자열이면 예외")
    void parseToNumbers_throwsOnBlank() {
        assertInvalidInput(() -> validator.parseToNumbers(" ", 1, 9, 3), InputErrorCode.INVALID_INPUT_EMPTY);
    }

    @Test
    @DisplayName("parseToNumbers: 숫자 외 문자가 있으면 예외")
    void parseToNumbers_throwsOnNonDigit() {
        assertInvalidInput(() -> validator.parseToNumbers("12a", 1, 9, 3), InputErrorCode.INVALID_INPUT_FORMAT);
    }

    @Test
    @DisplayName("parseToNumbers: 길이 불일치면 예외")
    void parseToNumbers_throwsOnInvalidLength() {
        assertInvalidInput(() -> validator.parseToNumbers("12", 1, 9, 3), InputErrorCode.INVALID_LENGTH);
    }

    @Test
    @DisplayName("parseToNumbers: 길이 초과면 예외")
    void parseToNumbers_throwsOnTooLongLength() {
        assertInvalidInput(() -> validator.parseToNumbers("1234", 1, 9, 3), InputErrorCode.INVALID_LENGTH);
    }

    @Test
    @DisplayName("parseToNumbers: 범위 밖 숫자면 예외")
    void parseToNumbers_throwsOnOutOfRange() {
        assertInvalidInput(() -> validator.parseToNumbers("109", 1, 9, 3), InputErrorCode.INVALID_NUMBER_RANGE);
    }

    @Test
    @DisplayName("parseToNumbers: 중복이면 예외")
    void parseToNumbers_throwsOnDuplicate() {
        assertInvalidInput(() -> validator.parseToNumbers("112", 1, 9, 3), InputErrorCode.DUPLICATE_NUMBER);
    }

    @Test
    @DisplayName("validateRange: 범위 내면 통과")
    void validateRange_allowsValuesWithinRange() {
        validator.validateRange(List.of(1, 2, 3), 1, 3);
    }

    @Test
    @DisplayName("validateRange: 범위 밖이면 예외")
    void validateRange_throwsOnOutOfRange() {
        assertInvalidInput(() -> validator.validateRange(List.of(1, 4, 3), 1, 3), InputErrorCode.INVALID_NUMBER_RANGE);
    }

    @Test
    @DisplayName("validateLength: 길이 일치하면 통과")
    void validateLength_allowsMatchingLength() {
        validator.validateLength(List.of(1, 2, 3), 3);
    }

    @Test
    @DisplayName("validateLength: 길이 다르면 예외")
    void validateLength_throwsOnMismatchedLength() {
        assertInvalidInput(() -> validator.validateLength(List.of(1, 2), 3), InputErrorCode.INVALID_LENGTH);
    }

    @Test
    @DisplayName("validateNoDuplicates: 중복 없으면 통과")
    void validateNoDuplicates_allowsUniqueValues() {
        validator.validateNoDuplicates(List.of(1, 2, 3));
    }

    @Test
    @DisplayName("validateNoDuplicates: 중복이면 예외")
    void validateNoDuplicates_throwsOnDuplicate() {
        assertInvalidInput(() -> validator.validateNoDuplicates(List.of(1, 2, 2)), InputErrorCode.DUPLICATE_NUMBER);
    }

    @Test
    @DisplayName("validateRestartInput: '1'이면 true")
    void validateRestartInput_returnsTrueForOne() {
        assertThat(validator.validateRestartInput("1")).isTrue();
    }

    @Test
    @DisplayName("validateRestartInput: '2'이면 false")
    void validateRestartInput_returnsFalseForTwo() {
        assertThat(validator.validateRestartInput("2")).isFalse();
    }

    @Test
    @DisplayName("validateRestartInput: 앞뒤 공백 허용")
    void validateRestartInput_allowsWhitespaceAroundInput() {
        assertThat(validator.validateRestartInput(" 1 ")).isTrue();
        assertThat(validator.validateRestartInput(" 2 ")).isFalse();
    }

    @Test
    @DisplayName("validateRestartInput: 빈 문자열이면 예외")
    void validateRestartInput_throwsOnEmpty() {
        assertInvalidInput(() -> validator.validateRestartInput(""), InputErrorCode.INVALID_INPUT_EMPTY);
    }

    @Test
    @DisplayName("validateRestartInput: null이면 NPE")
    void validateRestartInput_throwsOnNull() {
        assertThatThrownBy(() -> validator.validateRestartInput(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("validateRestartInput: 공백만 있으면 예외")
    void validateRestartInput_throwsOnWhitespaceOnly() {
        assertInvalidInput(() -> validator.validateRestartInput(" "), InputErrorCode.INVALID_RESTART_INPUT);
    }

    @Test
    @DisplayName("validateRestartInput: 그 외 값이면 예외")
    void validateRestartInput_throwsOnOtherValues() {
        assertInvalidInput(() -> validator.validateRestartInput("3"), InputErrorCode.INVALID_RESTART_INPUT);
    }

    private void assertInvalidInput(Runnable action, InputErrorCode expectedCode) {
        assertThatThrownBy(action::run)
                .isInstanceOf(InvalidInputException.class)
                .satisfies(e -> {
                    InvalidInputException ex = (InvalidInputException) e;
                    assertThat(ex.getErrorCode()).isEqualTo(expectedCode);
                });
    }
}

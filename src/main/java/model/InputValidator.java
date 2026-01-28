package model;

import model.exception.InvalidInputException;

import java.util.ArrayList;
import java.util.List;

import static model.exception.InputErrorCode.*;

public class InputValidator {

    public List<Integer> parseToNumbers(String input) {
        if (input.isEmpty()) {
            throw new InvalidInputException(INVALID_INPUT_EMPTY);
        }

        List<Integer> numbers = new ArrayList<>();
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new InvalidInputException(INVALID_INPUT_FORMAT);
            }
            numbers.add(c - '0');
        }

        return numbers;
    }

    public boolean hasNoDuplicates(List<Integer> numbers) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public boolean validateRestartInput(String input) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}

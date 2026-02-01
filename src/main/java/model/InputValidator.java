package model;

import model.exception.InvalidInputException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static model.exception.InputErrorCode.*;

public class InputValidator {

    public List<Integer> parseToNumbers(String input, int min, int max, int size) {
        if (input == null || input.trim().isEmpty()) {
            throw new InvalidInputException(INVALID_INPUT_EMPTY);
        }

        List<Integer> numbers = new ArrayList<>();
        for (char c : input.trim().toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new InvalidInputException(INVALID_INPUT_FORMAT);
            }
            numbers.add(c - '0');
        }

        validateInput(numbers, min, max, size);
        return numbers;
    }

    void validateInput(List<Integer> numbers, int min, int max, int size){
        validateRange(numbers, min, max);
        validateNoDuplicates(numbers);
        validateLength(numbers, size);
    }

    void validateLength(List<Integer> numbers, int size) {
        if(numbers.size() != size) throw new InvalidInputException(INVALID_LENGTH);
    }

    void validateRange(List<Integer> numbers, int min, int max) {
        for (Integer num : numbers) {
            if (num < min || num > max) {
                throw new InvalidInputException(INVALID_NUMBER_RANGE);
            }
        }
    }

    void validateNoDuplicates(List<Integer> numbers) {
        Set<Integer> seen = new HashSet<>();
        for (Integer num : numbers) {
            if (!seen.add(num)) {
                throw new InvalidInputException(DUPLICATE_NUMBER);
            }
        }
    }

    public boolean validateRestartInput(String input) {
        if (input.isEmpty()) {
            throw new InvalidInputException(INVALID_INPUT_EMPTY);
        }
        if (input.trim().equals("1")) {
            return true;
        }
        if (input.trim().equals("2")) {
            return false;
        }
        throw new InvalidInputException(INVALID_RESTART_INPUT);
    }
}

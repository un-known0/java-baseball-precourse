package view;

import model.GameResult;
import model.exception.UserException;

public class OutputView {

    private static final String ERROR_PREFIX = "[ERROR] ";

    public void printResult(GameResult result) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void printError(UserException e) {
        System.out.println(ERROR_PREFIX + e.getMessage());
    }
}

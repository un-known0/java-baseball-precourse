package view;

import model.GameResult;
import model.exception.UserException;

public class OutputView {

    private static final String ERROR_PREFIX = "[ERROR] ";

    private String formatResult(GameResult result) {
        if (result.getBall() + result.getStrike() == 0) {
            return "낫싱";
        }
        String s = "";
        if (result.getStrike() != 0) s += result.getStrike() + "스트라이크 ";
        if (result.getBall() != 0) s += result.getBall() + "볼";
        return s.trim();
    }

    public void printResult(GameResult result) {
        System.out.println(formatResult(result));
    }

    public void printGameEnd(int numberSize){
        System.out.println(numberSize + "개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }

    public void printError(UserException e) {
        System.out.println(ERROR_PREFIX + e.getMessage());
    }
}

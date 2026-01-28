package model;

import model.exception.InvalidInputException;

import java.util.List;

import static model.exception.InputErrorCode.*;


public class BaseballGameJudge {

    public void validateLength(List<Integer> answer, List<Integer> guess) {
        if(answer.size() != guess.size()) throw new InvalidInputException(INVALID_LENGTH);
    }

    public int countBall(List<Integer> answer, List<Integer> guess) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public int countStrike(List<Integer> answer, List<Integer> guess) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public GameResult judge(List<Integer> answer, List<Integer> guess) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public boolean isGameOver(GameResult result) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}

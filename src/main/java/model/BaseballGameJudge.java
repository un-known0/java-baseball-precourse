package model;

import model.exception.InvalidInputException;

import java.util.List;

import static model.exception.InputErrorCode.*;


public class BaseballGameJudge {

    int countBall(List<Integer> answer, List<Integer> guess) {
        int ball = 0;
        for (int i = 0; i < guess.size(); i++) {
            int num = guess.get(i);
            if (answer.contains(num) && !answer.get(i).equals(num)) {
                ball++;
            }
        }
        return ball;
    }

    int countStrike(List<Integer> answer, List<Integer> guess) {
        int strike = 0;
        for (int i = 0; i < guess.size(); i++) {
            if (answer.get(i).equals(guess.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    public GameResult judge(List<Integer> answer, List<Integer> guess) {
        return new GameResult(countBall(answer, guess), countStrike(answer, guess));
    }

}

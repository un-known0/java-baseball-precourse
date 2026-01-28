package model;

public class GameResult {

    private int goal;
    private int ball;
    private int strike;

    public GameResult(int goal, int ball, int strike) {
        this.goal = goal;
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public boolean isGameOver() {
        return goal == strike;
    }

}

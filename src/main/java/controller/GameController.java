package controller;

import model.BaseballGameJudge;
import model.InputValidator;
import model.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

import java.util.List;

public class GameController {

    private final RandomNumberGenerator randomNumberGenerator;
    private final BaseballGameJudge baseballGameJudge;
    private final InputValidator inputValidator;

    private final InputView inputView;
    private final OutputView outputView;

    public GameController() {
        this.randomNumberGenerator = new RandomNumberGenerator();
        this.baseballGameJudge = new BaseballGameJudge();
        this.inputValidator = new InputValidator();

        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public boolean playRound(List<Integer> answer) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public boolean handleRestart() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}

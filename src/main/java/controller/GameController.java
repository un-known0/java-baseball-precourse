package controller;

import model.BaseballGameJudge;
import model.GameResult;
import model.InputValidator;
import model.RandomNumberGenerator;
import model.exception.UserException;
import view.InputView;
import view.OutputView;

import java.util.List;

public class GameController {

    private static final int NUMBER_SIZE = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

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
        do{
            List<Integer> result = randomNumberGenerator.pickUniqueNumbers(MIN_NUMBER, MAX_NUMBER, NUMBER_SIZE);
//            List<Integer> result = List.of(1,2,3);
            while(!playRound(result)){
            }
            outputView.printGameEnd(NUMBER_SIZE);
        }while(handleRestart());
    }

    public boolean playRound(List<Integer> answer) {
        try{
            String input = inputView.readNumber();
            List<Integer> inputList = inputValidator.parseToNumbers(input, MIN_NUMBER, MAX_NUMBER, NUMBER_SIZE);
            GameResult judge = baseballGameJudge.judge(answer, inputList);
            outputView.printResult(judge);
            return judge.isGameOver(NUMBER_SIZE);
        }catch(UserException e){
            outputView.printError(e);
        }
        return false;
    }

    public boolean handleRestart() {
        while(true){
            try{
                String s = inputView.readRestartOption();
                return inputValidator.validateRestartInput(s);
            }catch(UserException e){
                outputView.printError(e);
            }
        }
    }
}

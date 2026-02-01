package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    private final BufferedReader br;

    public InputView(){
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    String input(){
        try{
            System.out.flush();
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String readNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return input();
    }

    public String readRestartOption() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return input();
    }
}

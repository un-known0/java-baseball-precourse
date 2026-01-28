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
        throw new UnsupportedOperationException("Not implemented yet");
    }
}

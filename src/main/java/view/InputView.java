package view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputView {

    private final BufferedReader br;

    public InputView(){
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readNumber() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public String readRestartOption() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}

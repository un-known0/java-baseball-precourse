package model;

import java.util.*;

public class RandomNumberGenerator {

    private final Random random;

    public RandomNumberGenerator(){
        random = new Random();
    }

    public int pickNumber(int start, int end) {
        if (start > end) throw new IllegalArgumentException("숫자의 범위가 올바르지 않습니다.");
        return random.nextInt(end-start+1) + start;
    }

    public List<Integer> pickUniqueNumbers(int start, int end, int count) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}

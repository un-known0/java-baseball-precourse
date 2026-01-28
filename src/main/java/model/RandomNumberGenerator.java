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
        if(end-start+1 < count) throw new IllegalArgumentException("원하는 개수의 숫자를 뽑을 수 없습니다");
        if(count<0) throw new IllegalArgumentException("0개 이하의 숫자를 뽑을 수 없습니다.");
        List<Integer> list = new ArrayList<>();
        Set<Integer> picks = new HashSet<>();

        while(list.size() < count){
            int pick = pickNumber(start, end);
            if(picks.contains(pick)) continue;
            list.add(pick);
            picks.add(pick);
        }

        return list;
    }
}

package _2024년._5월.programmers.lv2;

import java.util.HashMap;
import java.util.Map;

public class 롤케이크_자르기 {
    public int solution(int[] topping) {
        int result = 0;
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        for (int i : topping) {
            right.put(i, right.getOrDefault(i, 0) + 1);
        }

        for (int i : topping) {
            int size = right.get(i);

            if(size-1 == 0 || size == 0) {
                right.remove(i);
            } else {
                right.put(i, size-1);
            }

            left.put(i, left.getOrDefault(i, 0) + 1);

            if(left.size() == right.size()) {
                result++;
            }
        }

        return result;
    }
}

package _2024년._5월.programmers.lv2;

import java.util.ArrayDeque;
import java.util.Deque;

public class 뒤에_있는_큰_수_찾기 {
    public int[] solution(int[] numbers) {
        int[] result = new int[numbers.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0; i<numbers.length; i++) {
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                result[stack.pop()] = numbers[i];
            }

            stack.push(i);
        }

        for(int i=0; i<result.length; i++) {
            if(result[i] == 0) {
                result[i] = -1;
            }
        }

        return result;
    }
}

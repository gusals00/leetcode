package _2024년._6월.programmers.lv2;

import java.util.ArrayDeque;
import java.util.Deque;

public class 주식가격 {
    public int[] solution(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[prices.length];

        for(int i=0; i<prices.length; i++) {
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int pop = stack.pop();
                result[pop] = i-pop;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            int pop = stack.pop();
            result[pop] = prices.length-1-pop;
        }

        return result;
    }
}

package _2024년._2월.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];

        for(int i=0; i<temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                result[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }

        return result;
    }
}

package _2024년._11월.programmers.lv2;

import java.util.ArrayDeque;
import java.util.Deque;

public class 택배상자 {
    public int solution(int[] order) {
        int result = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        int box = 1;
        for (int i : order) {
            while(box <= order.length && box < i) {
                stack.push(box++);
            }

            if(box == i) {
                result++;
                box++;
            } else if(!stack.isEmpty() && stack.peek() == i) {
                stack.pop();
                result++;
            } else {
                return result;
            }
        }

        return result;
    }
}

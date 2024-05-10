package _2024년._5월.programmers.lv2;

import java.util.ArrayDeque;
import java.util.Deque;

public class 택배상자 {
    public int solution(int[] order) {
        int result = 0;
        int box = 1;
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0; i<order.length; i++) {
            while(box <= order.length && box < order[i]) {
                stack.push(box++);
            }

            if(order[i] == box) {
                result++;
                box++;
            } else if(!stack.isEmpty() && stack.peek() == order[i]) {
                stack.pop();
                result++;
            } else {
                break;
            }
        }

        return result;
    }
}

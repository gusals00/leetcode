package _2023년._9월.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();

        for(String s : tokens) {
            if(s.equals("+")) {
                deque.push(deque.pop() + deque.pop());
            } else if(s.equals("*")) {
                deque.push(deque.pop() * deque.pop());
            } else if(s.equals("-")) {
                Integer first = deque.pop();
                Integer second = deque.pop();
                deque.push(second - first);
            } else if(s.equals("/")) {
                Integer first = deque.pop();
                Integer second = deque.pop();
                deque.push(second / first);
            } else {
                deque.push(Integer.parseInt(s));
            }
        }

        return deque.pop();
    }
}

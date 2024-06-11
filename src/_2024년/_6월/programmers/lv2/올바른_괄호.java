package _2024년._6월.programmers.lv2;

import java.util.ArrayDeque;
import java.util.Deque;

public class 올바른_괄호 {
    public boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int length = s.length();

        for(int i=0; i<length; i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(c);
            } else {
                if(stack.isEmpty() || stack.peek() == ')') {
                    return false;
                }
                stack.pop();
            }
        }

        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}

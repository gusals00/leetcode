package _2023년._7월.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                deque.push(c);
            } else {
                if(deque.isEmpty()) {
                    return false;
                }
                if(c == ')' && deque.peek() == '(') {
                    deque.pop();
                } else if(c == '}' && deque.peek() == '{') {
                    deque.pop();
                } else if(c == ']' && deque.peek() == '[') {
                    deque.pop();
                } else {
                    return false;
                }
            }
        }

        return deque.isEmpty();
    }
}

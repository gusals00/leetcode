package _2023년._11월.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if(c == '(' || c == '[' || c == '{') {
                deque.push(c);
            } else {
                if(deque.isEmpty()) return false;
                char pop = deque.pop();

                if(!(c == ')' && pop == '(') && !(c == ']' && pop == '[') && !(c == '}' && pop == '{'))
                    return false;
            }
        }

        return deque.isEmpty();
    }
}

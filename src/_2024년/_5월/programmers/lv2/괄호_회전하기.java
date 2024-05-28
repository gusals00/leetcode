package _2024년._5월.programmers.lv2;

import java.util.ArrayDeque;
import java.util.Deque;

public class 괄호_회전하기 {
    public int solution(String s) {
        int result = 0;
        Deque<Character> stack = new ArrayDeque<>();

        int index = 0;
        for(int i=0; i<s.length(); i++) {
            stack.clear();

            for(int j=index; j<s.length()+index; j++) {
                char c = s.charAt(j % s.length());

                if(stack.isEmpty()) {
                    stack.push(c);
                } else if(stack.peek() == '(' && c == ')') {
                    stack.pop();
                } else if(stack.peek() == '[' && c == ']') {
                    stack.pop();
                } else if(stack.peek() == '{' && c == '}') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

            index++;
            if(stack.isEmpty()) {
                result++;
            }
        }

        return result;
    }
}

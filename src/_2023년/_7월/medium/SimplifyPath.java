package _2023년._7월.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> deque = new ArrayDeque<>();

        for(String s : path.split("/")) {
            if(s.isEmpty() || s.equals(".")) {
                continue;
            }
            if(s.equals("..")) {
                if(!deque.isEmpty()) {
                    deque.pop();
                }
            } else {
                deque.push(s);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("/");

        while(!deque.isEmpty()) {
            sb.append(deque.removeLast());
            if(deque.size() != 0) {
                sb.append("/");
            }
        }

        return sb.toString();
    }
}

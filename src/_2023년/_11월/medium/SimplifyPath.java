package _2023년._11월.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        Deque<String> deque = new ArrayDeque<>();

        for (String s : split) {
            if(s.isEmpty() || s.equals("."))
                continue;
            else if(s.equals("..")) {
                if(!deque.isEmpty()) {
                    deque.removeLast();
                }
            } else {
                deque.add(s);
            }
        }

        StringBuilder sb = new StringBuilder("/");
        for (String s : deque) {
            sb.append(s + "/");
        }

        if(sb.length() != 1)
            sb.deleteCharAt(sb.length()-1);

        return sb.toString();
    }
}

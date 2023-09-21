package _2023년._9월.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> deque = new ArrayDeque<>();

        for(String s : path.split("/")) {
            if(s.equals(".") || s.isEmpty())
                continue;
            if(s.equals("..")) {
                if(!deque.isEmpty())
                    deque.removeLast();
            }
            else {
                deque.addLast(s);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("/");
        while(!deque.isEmpty()) {
            sb.append(deque.remove() + "/");
        }

        if(sb.length() != 1)
            sb.deleteCharAt(sb.length()-1);

        return sb.toString();
    }
}

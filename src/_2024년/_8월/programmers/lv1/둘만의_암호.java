package _2024년._8월.programmers.lv1;

import java.util.HashSet;
import java.util.Set;

public class 둘만의_암호 {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        for (char c : skip.toCharArray()) {
            set.add(c);
        }

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            int count = 0;
            while(count < index) {
                c++;
                if(c > 'z') {
                    c = 'a';
                }

                if(!set.contains(c)) {
                    count++;
                }
            }

            sb.append(c);
        }

        return sb.toString();
    }
}

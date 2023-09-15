package _2023년._9월.easy;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> cs = new HashMap<>();
        Map<String, Character> sc = new HashMap<>();

        String[] strings = s.split(" ");

        if(strings.length != pattern.length())
            return false;

        for(int i=0; i<pattern.length(); i++) {
            char c = pattern.charAt(i);
            String string = strings[i];

            if(!cs.containsKey(c)) {
                cs.put(c, string);
            }
            if(!sc.containsKey(string)) {
                sc.put(string, c);
            }

            if(!cs.get(c).equals(string) || !(sc.get(string) == c)) {
                return false;
            }
        }

        return true;
    }
}

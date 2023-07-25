package _2023년._7월.easy;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");

        if(arr.length != pattern.length())
            return false;

        Map<Character, String> cTos = new HashMap<>();
        Map<String, Character> sToc = new HashMap<>();

        for(int i=0; i<pattern.length(); i++) {
            char c = pattern.charAt(i);
            String str = arr[i];

            if(!cTos.containsKey(c)) {
                cTos.put(c, str);
            }
            if(!sToc.containsKey(str)) {
                sToc.put(str, c);
            }
            if(!cTos.get(c).equals(str) || !sToc.get(str).equals(c)) {
                return false;
            }
        }

        return true;
    }
}

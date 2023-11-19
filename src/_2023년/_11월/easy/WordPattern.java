package _2023년._11월.easy;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> charToString = new HashMap<>();
        Map<String, Character> stringToChar = new HashMap<>();

        String[] strings = s.split(" ");
        if(strings.length != pattern.length()) return false;

        for(int i=0; i<pattern.length(); i++) {
            char c = pattern.charAt(i);
            String string = strings[i];

            if(!charToString.containsKey(c)) {
                charToString.put(c, string);
            }
            if(!stringToChar.containsKey(string)) {
                stringToChar.put(string, c);
            }

            if(!charToString.get(c).equals(string) || !(stringToChar.get(string) == c)) {
                return false;
            }
        }

        return true;
    }
}

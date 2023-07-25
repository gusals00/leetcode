package _2023년._7월.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        int result = 0;
        Map<Character, Integer> hmap = new HashMap<>();
        hmap.put('I', 1);
        hmap.put('V', 5);
        hmap.put('X', 10);
        hmap.put('L', 50);
        hmap.put('C', 100);
        hmap.put('D', 500);
        hmap.put('M', 1000);

        int length = s.length();
        for(int i = 0; i < length-1; i++) {
            if(hmap.get(s.charAt(i)) < hmap.get(s.charAt(i+1))) {
                result -= hmap.get(s.charAt(i));
            } else {
                result += hmap.get(s.charAt(i));
            }
        }

        result += hmap.get(s.charAt(length-1));

        return result;
    }
}

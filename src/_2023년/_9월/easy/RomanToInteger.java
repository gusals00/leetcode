package _2023년._9월.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> hmap = new HashMap<>();
        hmap.put('I', 1);
        hmap.put('V', 5);
        hmap.put('X', 10);
        hmap.put('L', 50);
        hmap.put('C', 100);
        hmap.put('D', 500);
        hmap.put('M', 1000);

        char prev = 'M';
        int result = 0;
        for(char c : s.toCharArray()) {
            if(hmap.get(c) > hmap.get(prev)) {
                result = result - hmap.get(prev)*2;
            }

            prev = c;
            result += hmap.get(c);
        }

        return result;
    }
}

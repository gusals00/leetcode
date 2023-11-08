package _2023년._11월.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;

        char prev = 'M';
        for (char c : s.toCharArray()) {
            if(map.get(c) > map.get(prev)) {
                result -= map.get(prev)*2;
            }

            result += map.get(c);
            prev = c;
        }

        return result;
    }
}

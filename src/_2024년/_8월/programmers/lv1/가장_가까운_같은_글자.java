package _2024년._8월.programmers.lv1;

import java.util.HashMap;
import java.util.Map;

public class 가장_가까운_같은_글자 {
    public int[] solution(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int[] result = new int[s.length()];

        for(int i=0; i<s.length(); i++) {
            if(!map.containsKey(s.charAt(i))) {
                result[i] = -1;
                map.put(s.charAt(i), i);
            } else {
                int index = map.get(s.charAt(i));
                result[i] = i-index;
                map.put(s.charAt(i), i);
            }
        }

        return result;
    }
}

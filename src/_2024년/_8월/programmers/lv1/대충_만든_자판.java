package _2024년._8월.programmers.lv1;

import java.util.HashMap;
import java.util.Map;

public class 대충_만든_자판 {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> map = new HashMap<>();

        for (String s : keymap) {
            char[] chars = s.toCharArray();
            for(int i=0; i<chars.length; i++) {
                if(map.containsKey(chars[i])) {
                    map.put(chars[i], Math.min(i+1, map.get(chars[i])));
                } else {
                    map.put(chars[i], i+1);
                }
            }
        }

        int[] result = new int[targets.length];
        for(int i=0; i<targets.length; i++) {
            char[] chars = targets[i].toCharArray();
            int count = 0;
            for(int j=0; j<chars.length; j++) {
                int value = map.getOrDefault(chars[j], 0);
                if(value == 0) {
                    count = -1;
                    break;
                } else {
                    count += value;
                }
            }

            result[i] = count;
        }

        return result;
    }
}

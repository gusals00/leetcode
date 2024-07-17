package _2024년._7월.programmers.lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 압축 {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        char word = 'A';
        for(int i=1; i<=26; i++, word++) {
            map.put(String.valueOf(word), i);
        }

        int index = 0;
        while(index < msg.length()) {
            StringBuilder sb = new StringBuilder();
            sb.append(msg.charAt(index));

            while(index+1 < msg.length() && map.containsKey(sb.toString() + msg.charAt(index+1))) {
                index++;
                sb.append(msg.charAt(index));
            }

            result.add(map.get(sb.toString()));

            if(index+1 < msg.length()) {
                map.put(sb.toString() + msg.charAt(index+1), map.size() + 1);
            }
            index++;
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}

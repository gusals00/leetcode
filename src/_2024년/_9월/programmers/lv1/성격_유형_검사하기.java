package _2024년._9월.programmers.lv1;

import java.util.HashMap;
import java.util.Map;

public class 성격_유형_검사하기 {
    public String solution(String[] survey, int[] choices) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<survey.length; i++) {
            int choice = choices[i];
            if(choice < 4) {
                char key = survey[i].charAt(0);
                map.put(key, map.getOrDefault(key, 0) + 4 - choice);
            } else if(choice > 4) {
                char key = survey[i].charAt(1);
                map.put(key, map.getOrDefault(key, 0) + choice - 4);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(map.getOrDefault('R', 0) >= map.getOrDefault('T', 0) ? "R" : "T");
        sb.append(map.getOrDefault('C', 0) >= map.getOrDefault('F', 0) ? "C" : "F");
        sb.append(map.getOrDefault('J', 0) >= map.getOrDefault('M', 0) ? "J" : "M");
        sb.append(map.getOrDefault('A', 0) >= map.getOrDefault('N', 0) ? "A" : "N");

        return sb.toString();
    }
}

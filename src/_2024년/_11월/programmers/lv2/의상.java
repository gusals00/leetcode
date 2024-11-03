package _2024년._11월.programmers.lv2;

import java.util.HashMap;
import java.util.Map;

public class 의상 {
    public int solution(String[][] clothes) {
        int result = 1;
        Map<String, Integer> map = new HashMap<>();

        for (String[] cloth : clothes) {
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }

        for (String s : map.keySet()) {
            result *= (map.get(s)+1);
        }

        return result-1;
    }
}

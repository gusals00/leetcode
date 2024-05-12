package _2024년._5월.programmers.lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class 귤_고르기 {
    public int solution(int k, int[] tangerine) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

        for (int i : list) {
            if(k <= 0) {
                break;
            }

            k -= map.get(i);
            result++;
        }

        return result;
    }
}

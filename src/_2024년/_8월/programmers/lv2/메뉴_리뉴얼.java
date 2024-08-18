package _2024년._8월.programmers.lv2;

import java.util.*;

public class 메뉴_리뉴얼 {
    int max = 0;
    HashMap<String, Integer> map = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        List<String> list = new ArrayList<>();

        for(int i=0; i<orders.length; i++) {
            char[] chars = orders[i].toCharArray();
            Arrays.sort(chars);
            orders[i] = String.valueOf(chars);
        }

        for(int c : course) {
            for(int i=0; i<orders.length; i++) {
                combination("", orders[i], c);
            }

            for(String str : map.keySet()) {
                if(map.get(str) >= 2 && map.get(str) == max) {
                    list.add(str);
                }
            }

            map.clear();
            max = 0;
        }


        Collections.sort(list);
        String[] result = new String[list.size()];
        for(int i=0; i<list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    private void combination(String str, String other, int count) {
        if(count == 0) {
            map.put(str, map.getOrDefault(str, 0) + 1);
            max = Math.max(max, map.get(str));
            return;
        }

        for(int i=0; i<other.length(); i++) {
            combination(str + other.charAt(i), other.substring(i+1), count-1);
        }
    }
}

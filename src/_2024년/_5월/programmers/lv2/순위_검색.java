package _2024년._5월.programmers.lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class 순위_검색 {
    public int[] solution(String[] info, String[] query) {
        Map<String, ArrayList<Integer>> map = new HashMap<>();
        int[] result = new int[query.length];

        for(int i=0; i<info.length; i++) {
            dfs(info[i].split(" "), "", 0, map);
        }

        for (ArrayList<Integer> value : map.values()) {
            Collections.sort(value);
        }

        for(int i=0; i<query.length; i++) {
            String[] str = query[i].split(" and ");
            String[] foodAndScore = str[3].split(" ");

            int score = Integer.parseInt(foodAndScore[1]);
            String find = str[0] + str[1] + str[2] + foodAndScore[0];

            if(!map.containsKey(find)) {
                result[i] = 0;
            } else {
                ArrayList<Integer> list = map.get(find);
                int start = 0;
                int end = list.size()-1;

                while(start <= end) {
                    int mid = (start + end) / 2;

                    if(list.get(mid) < score) {
                        start = mid + 1;
                    } else {
                        end = mid -1;
                    }
                }

                result[i] = list.size() - start;
            }
        }

        return result;
    }

    private void dfs(String[] info, String str, int index, Map<String, ArrayList<Integer>> map) {
        if(index == 4) {
            int score = Integer.parseInt(info[index]);
            if(!map.containsKey(str)) {
                map.put(str, new ArrayList<>());
            }
            map.get(str).add(score);

            return;
        }

        dfs(info, str + "-", index+1, map);
        dfs(info, str + info[index], index+1, map);
    }
}

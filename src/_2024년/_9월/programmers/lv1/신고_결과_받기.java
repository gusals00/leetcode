package _2024년._9월.programmers.lv1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 신고_결과_받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        boolean[][] reports = new boolean[id_list.length][id_list.length];
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<id_list.length; i++) {
            map.put(id_list[i], i);
        }

        for(String s : report) {
            String[] split = s.split(" ");
            reports[map.get(split[0])][map.get(split[1])] = true;
        }

        int[] result = new int[id_list.length];
        for(int i=0; i<id_list.length; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j=0; j<id_list.length; j++) {
                if(reports[j][i] == true) {
                    list.add(j);
                }
            }

            if(list.size() >= k) {
                for (int index : list) {
                    result[index]++;
                }
            }
        }

        return result;
    }
}

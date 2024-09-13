package _2024년._9월.programmers.lv1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 실패율 {
    public int[] solution(int N, int[] stages) {
        int[] stageCount = new int[N+2];
        int[] stageFailCount = new int[N+2];

        for (int stage : stages) {
            stageFailCount[stage]++;
        }

        stageCount[1] = stages.length;
        for(int i=2; i<N+2; i++) {
            stageCount[i] = stageCount[i-1] - stageFailCount[i-1];
        }

        Map<Integer, Double> map = new HashMap<>();
        for(int i=1; i<=N; i++) {
            if(stageFailCount[i] == 0) {
                map.put(i, 0.0);
            } else {
                map.put(i, (double) stageFailCount[i] / stageCount[i]);
            }
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> Double.compare(map.get(o2), map.get(o1)));

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}

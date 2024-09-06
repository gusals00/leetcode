package _2024년._9월.programmers.lv1;

import java.util.HashMap;
import java.util.Map;

public class 추억_점수 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] result = new int[photo.length];
        Map<String, Integer> map = new HashMap<>();

        for(int i=0; i<name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        for(int i=0; i<photo.length; i++) {
            int sum = 0;
            for(int j=0; j<photo[i].length; j++) {
                sum += map.getOrDefault(photo[i][j], 0);
            }

            result[i] = sum;
        }

        return result;
    }
}

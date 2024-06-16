package _2024년._6월.programmers.lv1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class 데이터_분석 {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> map = new HashMap<>();
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);

        return Arrays.stream(data)
                .filter(x -> x[map.get(ext)] < val_ext)
                .sorted(Comparator.comparing(x -> x[map.get(sort_by)]))
                .toArray(int[][]::new);
    }
}

package _2024년._6월.programmers.lv1;

import java.util.ArrayList;
import java.util.List;

public class 같은_숫자는_싫어 {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();

        int prev = -1;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] != prev) {
                list.add(arr[i]);
                prev = arr[i];
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}

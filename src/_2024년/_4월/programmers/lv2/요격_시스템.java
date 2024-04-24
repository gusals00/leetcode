package _2024년._4월.programmers.lv2;

import java.util.Arrays;
import java.util.Comparator;

public class 요격_시스템 {
    public int solution(int[][] targets) {
        int result = 0;
        Arrays.sort(targets, Comparator.comparingInt(target -> target[1]));

        int prev = -1;
        for (int[] target : targets) {
            if(prev <= target[0]) {
                result++;
                prev = target[1];
            }
        }

        return result;
    }
}

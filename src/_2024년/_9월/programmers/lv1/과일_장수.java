package _2024년._9월.programmers.lv1;

import java.util.Arrays;

public class 과일_장수 {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        int result = 0;
        int count = 0;
        int lowestScore = Integer.MAX_VALUE;

        for(int i=score.length-1; i>=0; i--) {
            lowestScore = Math.min(lowestScore, score[i]);
            count++;

            if(count == m) {
                count = 0;
                result += lowestScore * m;
                lowestScore = Integer.MAX_VALUE;
            }
        }

        return result;
    }
}

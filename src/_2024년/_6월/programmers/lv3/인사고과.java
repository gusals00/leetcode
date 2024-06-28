package _2024년._6월.programmers.lv3;

import java.util.Arrays;

public class 인사고과 {
    public int solution(int[][] scores) {
        int result = 1;
        int[] score = scores[0];
        Arrays.sort(scores, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            }

            return Integer.compare(o2[0], o1[0]);
        });

        int peerScore = scores[0][1];
        for(int i=1; i<scores.length; i++) {
            if(peerScore > scores[i][1]) {
                if(Arrays.equals(scores[i], score)) {
                    return -1;
                }

                scores[i][0] = -1;
                scores[i][1] = -1;
            } else {
                peerScore = scores[i][1];
            }
        }

        Arrays.sort(scores, (o1, o2) -> Integer.compare(o2[0] + o2[1], o1[0] + o1[1]));

        int scoreSum = score[0] + score[1];
        for(int i=0; i<scores.length; i++) {
            if(scoreSum < scores[i][0] + scores[i][1]) {
                result++;
            } else {
                break;
            }
        }

        return result;
    }
}

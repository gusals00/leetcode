package _2024년._9월.programmers.lv2;

import java.util.Arrays;

public class 퍼즐게임_챌린지 {
    public int solution(int[] diffs, int[] times, long limit) {
        int start = 0;
        int end = Arrays.stream(diffs).max().getAsInt();

        while(start + 1 < end) {
            int mid = (start + end) / 2;

            if(!check(mid, diffs, times, limit)) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return end;
    }

    private boolean check(int mid, int[] diffs, int[] times, long limit) {
        long totalTime = 0;
        int prevTime = 0;
        for(int i=0; i<diffs.length; i++) {
            if(mid >= diffs[i]) {
                totalTime += times[i];
            } else {
                totalTime += (prevTime + times[i]) * (diffs[i]-mid) + times[i];
            }

            prevTime = times[i];
        }

        if(totalTime <= limit) {
            return true;
        } else {
            return false;
        }
    }
}

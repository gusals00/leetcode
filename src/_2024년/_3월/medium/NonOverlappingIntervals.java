package _2024년._3월.medium;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
        int prev = intervals[0][1];
        int result = 0;

        for(int i=1; i<intervals.length; i++) {
            if(prev <= intervals[i][0]) {
                prev = intervals[i][1];
            } else {
                result++;
            }
        }

        return result;
    }
}

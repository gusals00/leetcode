package _2024년._2월.medium;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[1]));
        int end = intervals[0][1];
        int count = 0;
        for(int i=1; i<intervals.length; i++) {
            if(end > intervals[i][0]) {
                count++;
            } else {
                end = intervals[i][1];
            }
        }

        return count;
    }
}

package _2023년._9월.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        for(int i=0; i<intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            while(i+1 < intervals.length && end >= intervals[i+1][0]) {
                i++;
                start = Math.min(intervals[i][0], start);
                end = Math.max(intervals[i][1], end);
            }

            result.add(new int[]{start,end});
        }

        return result.toArray(new int[0][]);
    }
}

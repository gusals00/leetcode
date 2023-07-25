package _2023년._7월.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>(new ArrayList<>());

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        for(int i=0; i<intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            int nextStart = start;
            int nextEnd = end;
            while(i+1 < intervals.length && nextEnd >= intervals[i+1][0]) {
                i++;
                nextStart = Math.min(nextStart, intervals[i][0]);
                nextEnd = Math.max(nextEnd, intervals[i][1]);
            }

            list.add(new int[]{nextStart, nextEnd});
        }

        return list.toArray(new int[0][]);
    }
}

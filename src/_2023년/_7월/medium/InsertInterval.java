package _2023년._7월.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newArr = new int[intervals.length+1][2];
        for(int i=0; i<intervals.length; i++) {
            newArr[i][0] = intervals[i][0];
            newArr[i][1] = intervals[i][1];
        }

        newArr[newArr.length-1][0] = newInterval[0];
        newArr[newArr.length-1][1] = newInterval[1];

        Arrays.sort(newArr, Comparator.comparingInt(o -> o[0]));

        List<int[]> list = new ArrayList<>(new ArrayList<>());


        for(int i=0; i<newArr.length; i++) {
            int start = newArr[i][0];
            int end = newArr[i][1];

            int nextStart = start;
            int nextEnd = end;
            while(i+1 < newArr.length && nextEnd >= newArr[i+1][0]) {
                i++;
                nextStart = Math.min(nextStart, newArr[i][0]);
                nextEnd = Math.max(nextEnd, newArr[i][1]);
            }

            list.add(new int[]{nextStart, nextEnd});
        }

        return list.toArray(new int[0][]);
    }
}

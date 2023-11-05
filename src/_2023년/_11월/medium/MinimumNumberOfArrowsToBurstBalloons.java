package _2023년._11월.medium;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(value -> value[1]));

        int prev = points[0][1];
        int result = 1;
        for(int i=1; i<points.length; i++) {
            if(points[i][0] <= prev)
                continue;
            else {
                prev = points[i][1];
                result++;
            }
        }

        return result;
    }
}

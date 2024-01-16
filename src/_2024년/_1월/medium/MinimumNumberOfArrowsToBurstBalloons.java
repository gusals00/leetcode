package _2024년._1월.medium;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(value -> value[1]));

        int temp = points[0][1];
        int arrow = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= temp) {
                continue;
            } else {
                temp = points[i][1];
                arrow++;
            }
        }

        return arrow;
    }
}

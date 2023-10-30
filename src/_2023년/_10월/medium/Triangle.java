package _2023년._10월.medium;

import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] dp = new int[size][size];

        for(int i=0; i<size; i++) {
            dp[size-1][i] = triangle.get(size-1).get(i);
        }

        for(int i=size-2; i>=0; i--) {
            for(int j=0; j<=i; j++) {
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j);
            }
        }

        return dp[0][0];
    }
}

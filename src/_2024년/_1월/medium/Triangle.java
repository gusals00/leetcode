package _2024년._1월.medium;

import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[] dp = new int[n];
        for(int i=0; i<n; i++) {
            dp[i] = triangle.get(m - 1).get(i);
        }

        for(int i=m-2; i>=0; i--) {
            List<Integer> integers = triangle.get(i);
            for(int j=0; j<integers.size(); j++) {
                dp[j] = Math.min(dp[j], dp[j+1]) + integers.get(j);
            }
        }

        return dp[0];
    }
}

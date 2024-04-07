package _2024년._4월.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        int[][] dp = new int[numRows][numRows];
        dp[0][0] = 1;
        result.add(List.of(dp[0][0]));

        for(int i=1; i<numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j=0; j<=i; j++) {
                if(j == 0) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                }
                list.add(dp[i][j]);
            }
            result.add(list);
        }

        return result;
    }
}

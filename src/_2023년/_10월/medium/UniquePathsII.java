package _2023년._10월.medium;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];

        for(int i=0; i<m && obstacleGrid[0][i]!=1; i++) {
            dp[0][i] = 1;
        }
        for(int i=0; i<n && obstacleGrid[i][0]!=1; i++) {
            dp[i][0] = 1;
        }

        for(int i=1; i<n; i++) {
            for(int j=1; j<m; j++) {
                if(obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[n-1][m-1];
    }
}

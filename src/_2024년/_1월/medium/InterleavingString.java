package _2024년._1월.medium;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        if(n + m != s3.length()) {
            return false;
        }

        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;

        for(int i=1; i<dp.length && dp[i-1][0]; i++) {
            dp[i][0] = s1.charAt(i-1) == s3.charAt(i-1);
        }
        for(int i=1; i<dp[0].length && dp[0][i-1]; i++) {
            dp[0][i] = s2.charAt(i-1) == s3.charAt(i-1);
        }

        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[i].length; j++) {
                dp[i][j] = ((dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) ||
                        dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
            }
        }

        return dp[n][m];
    }
}

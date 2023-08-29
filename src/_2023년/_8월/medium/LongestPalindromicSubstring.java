package _2023년._8월.medium;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        int start = 0, end = 0;
        boolean[][] dp = new boolean[n][n];

        for(int len=0; len<n; len++) {
            for(int j=0; len+j<n; j++) {
                dp[j][len+j] = s.charAt(j) == s.charAt(len+j) && (len < 2 || dp[j+1][len+j-1]);
                if(dp[j][len+j] && len > end-start) {
                    start = j;
                    end = j+len;
                }
            }
        }

        return s.substring(start, end+1);
    }
}

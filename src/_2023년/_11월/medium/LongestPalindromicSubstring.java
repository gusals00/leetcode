package _2023년._11월.medium;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0, end = 0;

        for (int length = 0; length < n; length++) {
            for (int i = 0; i + length < n; i++) {
                if((length < 2 || dp[i+1][i+length-1]) && s.charAt(i) == s.charAt(i+length)) {
                    dp[i][i+length] = true;
                }
                if(dp[i][i+length] && end-start < length) {
                    start = i;
                    end = i+length;
                }
            }
        }

        return s.substring(start, end+1);
    }
}

package _2024년._4월.medium;

public class DecodeWays {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for(int i=2; i<=s.length(); i++) {
            int one = Integer.valueOf(s.substring(i-1, i));
            int two = Integer.valueOf(s.substring(i-2, i));

            if(1 <= one && one <= 9) {
                dp[i] += dp[i-1];
            }
            if(10 <= two && two <= 26) {
                dp[i] += dp[i-2];
            }
        }

        return dp[s.length()];
    }
}

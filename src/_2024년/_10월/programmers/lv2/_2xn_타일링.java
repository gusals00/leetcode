package _2024년._10월.programmers.lv2;

public class _2xn_타일링 {
    public int solution(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1_000_000_007;
        }

        return dp[n];
    }
}

package _2024년._10월.programmers.lv2;

public class _3xn_타일링 {
    public int solution(int n) {
        int mod = 1_000_000_007;
        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[2] = 3;

        for(int i=4; i<=n; i+=2) {
            dp[i] = ((dp[i-2]*4 - dp[i-4]) % mod + mod) % mod;
        }

        return (int)dp[n];
    }
}

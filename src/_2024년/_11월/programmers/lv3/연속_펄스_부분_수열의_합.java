package _2024년._11월.programmers.lv3;

public class 연속_펄스_부분_수열의_합 {
    public long solution(int[] sequence) {
        long result;
        long[] dp = new long[sequence.length];
        long[] dp2 = new long [sequence.length];
        dp[0] = sequence[0];
        dp2[0] = sequence[0]*-1;
        result = Math.max(dp[0], dp2[0]);

        int n = -1;
        for(int i=1; i<sequence.length; i++) {
            dp[i] = Math.max(dp[i-1] + sequence[i]*n, sequence[i]*n);
            dp2[i] = Math.max(dp2[i-1] + sequence[i]*n*-1, sequence[i]*n*-1);
            n *= -1;

            long max = Math.max(dp[i], dp2[i]);
            result = Math.max(result, max);
        }

        return result;
    }
}

package _2023년._8월.medium;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];

        for(int i=1; i<=amount; i++) {
            dp[i] = amount+1;
            for(int c : coins) {
                if(i-c >= 0) {
                    dp[i] = Math.min(dp[i], dp[i-c]+1);
                }
            }
        }

        if(dp[amount] > amount) {
            return -1;
        } else {
            return dp[amount];
        }
    }
}

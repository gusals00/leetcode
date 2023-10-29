package _2023년._10월.medium;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];

        for(int i=1; i<=amount; i++) {
            dp[i] = dp.length;
            for (int coin : coins) {
                if(i-coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
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

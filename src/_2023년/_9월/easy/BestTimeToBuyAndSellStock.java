package _2023년._9월.easy;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int result = 0;
        for(int n : prices) {
            if(n < min) {
                min = n;
            }

            int profit = n - min;
            if(result < profit) {
                result = profit;
            }
        }

        return result;
    }
}

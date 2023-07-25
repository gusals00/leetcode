package _2023년._7월.easy;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int result = 0;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<prices.length; i++) {
            if(prices[i] < min) {
                min = prices[i];
            }

            int profit = prices[i] - min;
            if(result < profit) {
                result = profit;
            }
        }

        return result;
    }
}

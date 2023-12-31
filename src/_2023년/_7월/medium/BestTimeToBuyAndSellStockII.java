package _2023년._7월.medium;

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int result = 0;

        for(int i=0; i<prices.length-1; i++) {
            if(prices[i] < prices[i+1]) {
                result += prices[i+1] - prices[i];
            }
        }

        return result;
    }
}

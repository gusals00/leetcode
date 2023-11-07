package _2023년._11월.easy;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;

        for (int price : prices) {
            min = Math.min(price, min);
            maxProfit = Math.max(maxProfit, price-min);
        }

        return maxProfit;
    }
}

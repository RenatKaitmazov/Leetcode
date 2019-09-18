package easy;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 *
 * @author Renat Kaitmazov
 */

public final class BuyAndSellStock {

    public int maxProfit(int[] prices) {
        final int size = prices.length;
        if (size == 0) {
            return 0;
        }
        int cheapestStockPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < size; ++i) {
            final int currentStockPrice = prices[i];
            if (currentStockPrice < cheapestStockPrice) {
                cheapestStockPrice = currentStockPrice;
                continue;
            }
            if (currentStockPrice > cheapestStockPrice) {
                final int profit = currentStockPrice - cheapestStockPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }
}

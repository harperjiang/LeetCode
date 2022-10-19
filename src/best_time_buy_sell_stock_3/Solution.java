package best_time_buy_sell_stock_3;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 2)
            return 0;
        // Scan twice to determine the max profit before a point and after a point
        int buffer[] = new int[prices.length];
        int maxProfit = 0;
        // lowest point before
        int lpb = prices[0];
        buffer[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Integer.max(maxProfit, prices[i] - lpb);
            lpb = Integer.min(lpb, prices[i]);
            buffer[i] = maxProfit;
        }
        // No profit from single transaction means no profit
        if (maxProfit == 0)
            return 0;

        int mpaProfit = 0;
        // max point after
        int mpa = prices[prices.length - 1];
        for (int i = prices.length - 2; i > 0; i--) {
            mpaProfit = Integer.max(mpaProfit, mpa - prices[i]);
            mpa = Integer.max(mpa, prices[i]);
            maxProfit = Integer.max(maxProfit, mpaProfit + buffer[i - 1]);
        }

        return maxProfit;
    }
}

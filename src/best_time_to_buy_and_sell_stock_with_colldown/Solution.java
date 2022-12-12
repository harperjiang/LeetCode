package best_time_to_buy_and_sell_stock_with_colldown;

import java.util.Arrays;

public class Solution {

    public int maxProfit(int[] prices) {
        int[] buffer = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            buffer[i] = buffer[i - 1];
            for (int j = i - 1; j >= 0; j--) {
                if (prices[i] > prices[j]) {
                    int sum = prices[i] - prices[j];
                    if (j >= 2)
                        sum += buffer[j - 2];
                    buffer[i] = Math.max(buffer[i],sum);
                }
            }
        }
        return buffer[prices.length-1];
    }
}

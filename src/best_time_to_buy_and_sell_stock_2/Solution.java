package best_time_to_buy_and_sell_stock_2;

import java.util.Arrays;

public class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int sum = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                sum += prices[i] - min;
                min = prices[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}

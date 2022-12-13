package best_time_to_buy_and_sell_stock_with_colldown;

import java.util.Arrays;

public class Solution {

    public int maxProfit(int[] prices) {
        int[] buffer = new int[3];
        buffer[0] = -prices[0]; // hold
        buffer[1] = 0;             // sold
        buffer[2] = 0;          // reset

        for (int i = 1; i < prices.length; i++) {
            int hold = Math.max(buffer[0], buffer[2] - prices[i]);
            int sold = buffer[0] + prices[i];
            int reset = Math.max(buffer[2], buffer[1]);
            buffer[0] = hold;
            buffer[1] = sold;
            buffer[2] = reset;
        }
        return Math.max(buffer[1],buffer[2]);
    }

    public static void main(String[] args) {
        new Solution().maxProfit(new int[]{1,2,4});
    }
}

package best_time_to_buy_and_sell_stock_3;

public class Solution2 {
    public int maxProfit(int[] prices) {
        int[][] buffer = new int[prices.length+1][5];
        buffer[0] = new int[]{0, -1000000, -1000000, -1000000, -1000000};
        for(int i = 1 ; i <= prices.length; i++) {
            buffer[i][0] = buffer[i-1][0];
            buffer[i][1] = Math.max(buffer[i-1][1], buffer[i-1][0]-prices[i-1]);
            buffer[i][2] = Math.max(buffer[i-1][2], buffer[i-1][1]+prices[i-1]);
            buffer[i][3] = Math.max(buffer[i-1][3], buffer[i-1][2]-prices[i-1]);
            buffer[i][4] = Math.max(buffer[i-1][4], buffer[i-1][3]+prices[i-1]);
        }
        return Math.max(0, Math.max(buffer[prices.length][2],buffer[prices.length][4]));
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().maxProfit(new int[]{2,1,3,0,5}));
    }
}

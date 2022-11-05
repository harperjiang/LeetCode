package minimum_path_sum;

import java.util.Arrays;

public class Solution {
    public int minPathSum(int[][] grid) {
        int length = grid[0].length;
        int[] dp = new int[length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int[] row : grid) {
            dp[0] += row[0];
            for (int i = 1; i < length; ++i) {
                dp[i] = Math.min(dp[i - 1], dp[i]) + row[i];
            }
        }
        return dp[length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minPathSum(new int[][]{
                new int[]{1, 3, 1}, new int[]{1, 5, 1}, new int[]{4, 2, 1}
        }));
    }
}

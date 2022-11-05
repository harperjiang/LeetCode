package unique_paths_2;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int length = obstacleGrid[0].length;
        int[] dp = new int[length];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int i = 0; i < length; ++i) {
                if (row[i] == 1) {
                    dp[i] = 0;
                } else {
                    if (i > 0) {
                        dp[i] += dp[i - 1];
                    }
                }
            }
        }
        return dp[length - 1];
    }
}

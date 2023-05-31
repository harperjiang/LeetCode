package max_coins;

public class Solution {
    public int maxCoins(int[] nums) {

        int n = nums.length + 2;
        int[] ns = new int[n];
        System.arraycopy(nums, 0, ns, 1, nums.length);
        ns[0] = 1;
        ns[n - 1] = 1;

        int dp[][] = new int[n][n];
        for (int i = 1; i < n - 1; i++) {
            dp[i][i] = ns[i - 1] * ns[i] * ns[i + 1];
        }
        for (int i = n - 2; i >= 1; i--) {
            for (int j = i; j <= n - 2; j++) {
                // Compute dp[i][j]
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k - 1] + dp[k + 1][j] + ns[k] * ns[i - 1] * ns[j + 1]);
                }
//                System.out.println("" + i + "," + j + ":" + dp[i][j]);
            }
        }
        return dp[1][n - 2];
    }

    public int maxCoins2(int[] nums) {
        // add 1 before and after nums
        int n = nums.length + 2;
        int[] newNums = new int[n];
        System.arraycopy(nums, 0, newNums, 1, n - 2);
        newNums[0] = 1;
        newNums[n - 1] = 1;
        // dp[i][j] represents
        // maximum if we burst all nums[left]...nums[right], inclusive
        int[][] dp = new int[n][n];
        // do not include the first one and the last one
        // since they are both fake balloons added by ourselves and we can not burst
        // them
        for (int left = n - 2; left >= 1; left--) {
            for (int right = left; right <= n - 2; right++) {
                // find the last burst one in newNums[left]...newNums[right]
                for (int i = left; i <= right; i++) {
                    // newNums[i] is the last burst one
                    int gain = newNums[left - 1] * newNums[i] * newNums[right + 1];
                    // recursively call left side and right side
                    int remaining = dp[left][i - 1] + dp[i + 1][right];
                    // update
                    dp[left][right] = Math.max(remaining + gain, dp[left][right]);
                }
            }
        }
        // burst newNums[1]...newNums[n-2], excluding the first one and the last one
        return dp[1][n - 2];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxCoins(new int[]{3, 1, 5, 8}));
        System.out.println(new Solution().maxCoins2(new int[]{3, 1, 5, 8}));
    }
}

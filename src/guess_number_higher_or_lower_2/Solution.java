package guess_number_higher_or_lower_2;

public class Solution {

    public int getMoneyAmount(int n) {
        if (n == 1) {
            return 0;
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int interval = 1; interval < n; interval++) {
            for (int i = 0; i + interval <= n; i++) {
                int j = i + interval;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.min(dp[i][j], k + Math.max(k - 1 < i ? 0 : dp[i][k - 1], k + 1 > j ? 0 : dp[k + 1][j]));
                }
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getMoneyAmount(62));
    }
}

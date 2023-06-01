package arithmetic_slice_2;

import java.util.*;

public class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        // dp[i][k] is the number of subseqs that ends at i and has interval k
        // dp[i][k] += dp[j][k] where nums[i]-nums[j] = k

        Map[] dp = new Map[nums.length];

        for (int i = 0; i < nums.length; i++) {
            dp[i] = new HashMap<>();
            Map<Long, Integer> dpi = dp[i];
            for (int j = 0; j < i; j++) {
                Map<Integer, Integer> dpj = dp[j];
                Long interval = (long) nums[i] - (long) nums[j];
                if (dpj.containsKey(interval)) {
                    dpi.put(interval, dpi.getOrDefault(interval, 0) + dpj.get(interval) + 1);
                } else {
                    dpi.put(interval, dpi.getOrDefault(interval, 0) + 1);
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            Map<Integer, Integer> dpi = dp[i];
            for (int c : dpi.values()) {
                sum += c;
            }
        }
        sum -= nums.length * (nums.length - 1) / 2;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfArithmeticSlices(new int[]{2, 4, 6, 8, 10}));
        System.out.println(new Solution().numberOfArithmeticSlices(new int[]{7, 7, 7, 7, 7}));
        System.out.println(new Solution().numberOfArithmeticSlices(new int[]{0,2000000000,-294967296}));
    }
}

package house_robber;

import java.util.Arrays;

public class Solution {

    int dfs(int[] nums, int[] buffer, int start) {
        if (start >= nums.length) {
            return 0;
        }
        if (buffer[start] >= 0) {
            return buffer[start];
        }
        if (start == nums.length - 1) {
            return nums[start];
        }
        int max = -1;
        for (int i = start; i < nums.length; ++i) {
            int current = nums[i] + dfs(nums, buffer, i + 2);
            max = Math.max(current, max);
        }
        buffer[start] = max;
        return max;
    }

    public int rob(int[] nums) {
        int[] buffer = new int[nums.length];
        Arrays.fill(buffer, -1);
        return dfs(nums, buffer, 0);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[]{1, 2}));
    }
}

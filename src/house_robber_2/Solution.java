package house_robber_2;

import java.util.Arrays;

public class Solution {

    int dfs(int[] nums, int[] buffer, int start, int limit) {
        if (start >= limit) {
            return 0;
        }
        if (buffer[start] != -1) {
            return buffer[start];
        }
        int max = Math.max(nums[start] + dfs(nums, buffer, start + 2, limit), dfs(nums, buffer, start + 1, limit));
        buffer[start] = max;
        return max;
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        if (nums.length == 3) {
            return Math.max(nums[0], Math.max(nums[1], nums[2]));
        }
        int[] buffer1 = new int[nums.length];
        int[] buffer2 = new int[nums.length];
        Arrays.fill(buffer1,-1);
        Arrays.fill(buffer2,-1);
        return Math.max(dfs(nums, buffer1, 0, nums.length - 1), dfs(nums, buffer2, 1, nums.length));
    }
}

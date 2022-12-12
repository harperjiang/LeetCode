package threesum_smaller;

import java.util.Arrays;

public class Solution {

    int countsum(int[] nums, int start, int depth, int remain) {
        if (depth == 2) {
            int sum = 0;
            for (int i = start; i < nums.length && nums[i] < remain; i++) {
                sum += 1;
            }
            return sum;
        }
        int sum = 0;
        for (int i = start; i < nums.length && nums[i] < remain; i++) {
            sum += countsum(nums, i + 1, depth + 1, remain - nums[i]);
        }
        return sum;
    }

    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            nums[i] += 100;
        }
        return countsum(nums, 0, 0, target + 300);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().threeSumSmaller(new int[]{-1, 1, -1, -1}, -1));
    }
}

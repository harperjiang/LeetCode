package threesum_smaller;

import java.util.Arrays;

public class Solution2 {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int remain = target - nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < nums.length - 1 && left < right) {
                if (nums[left] + nums[right] < remain) {
                    count += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }
}

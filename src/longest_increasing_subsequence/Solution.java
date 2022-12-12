package longest_increasing_subsequence;

import java.util.Arrays;

public class Solution {

    public int lengthOfLIS(int[] nums) {
        int[] buffer = new int[nums.length];
        Arrays.fill(buffer, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    buffer[i] = Math.max(buffer[i], buffer[j] + 1);
                }
            }
        }
        int max = 0;
        for(int i = 0 ; i < nums.length;i++) {
           max = Math.max(buffer[i],max);
        }
        return max;
    }
}

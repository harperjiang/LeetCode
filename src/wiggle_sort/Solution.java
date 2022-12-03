package wiggle_sort;

import java.util.Arrays;

public class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int firstHalf = (nums.length + 1) / 2;
        int secondHalf = nums.length - firstHalf;
        int[] buffer = new int[secondHalf];
        System.arraycopy(nums, firstHalf, buffer, 0, secondHalf);
        for (int i = 0; i < firstHalf; i++) {
            nums[(firstHalf - 1 - i) * 2] = nums[firstHalf - 1 - i];
        }
        for (int i = 0; i < secondHalf; i++) {
            nums[i * 2 + 1] = buffer[i];
        }
    }
}

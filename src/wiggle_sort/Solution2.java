package wiggle_sort;

import java.util.Arrays;

public class Solution2 {

    void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void wiggleSort(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        boolean up = true;
        for (int i = 1; i < nums.length; i++) {
            if (up && nums[i] < nums[i - 1]) {
                swap(nums, i, i - 1);
            }
            if (!up && nums[i] > nums[i - 1]) {
                swap(nums, i, i - 1);
            }
            up = !up;
        }
    }
}

package sort_colors;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {

    void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int p0 = 0, p1 = 0, p2 = 0;
        while (p2 < nums.length)
            switch (nums[p2]) {
                case 0:
                    if (p0 < p2) {
                        swap(nums, p0++, p2);
                        if (p0 > p1) {
                            p1 = p0;
                        } else {
                            swap(nums, p1++, p2++);
                        }
                    } else {
                        p0++;
                        p1++;
                        p2++;
                    }
                    break;
                case 1:
                    swap(nums, p1++, p2++);
                    break;
                case 2:
                    p2++;
                    break;
            }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0};
        new Solution().sortColors(nums);
        System.out.println(Arrays.stream(nums).mapToObj(i -> String.valueOf(i)).collect(Collectors.joining(",")));
    }
}

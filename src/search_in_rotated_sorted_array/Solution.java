package search_in_rotated_sorted_array;

import java.util.Arrays;

public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return target == nums[0] ? 0 : -1;
        }
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            if (left == right) {
                return (nums[left] == target) ? left : -1;
            }
            if (nums[left] < nums[right]) {
                return Math.max(-1, Arrays.binarySearch(nums, left, right + 1, target));
            }
            if (left == right - 1) {
                if (target == nums[left]) {
                    return left;
                }
                if (target == nums[right]) {
                    return right;
                }
                return -1;
            }
            int middle = (left + right) / 2;

            // Case 1, pivot in [left, middle)
            if (nums[middle] < nums[right]) {
                if (target >= nums[middle] && target <= nums[right]) {
                    return Math.max(-1, Arrays.binarySearch(nums, middle, right + 1, target));
                } else {
                    right = middle - 1;
                }
            } else if (nums[left] < nums[middle]) { // Case 2, pivot in [middle, right]
                if (target >= nums[left] && target <= nums[middle]) {
                    return Math.max(-1, Arrays.binarySearch(nums, left, middle + 1, target));
                } else {
                    left = middle + 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
//        System.out.println(new Solution().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
//        System.out.println(new Solution().search(new int[]{1}, 0));
//        System.out.println(new Solution().search(new int[]{1}, 1));
//        System.out.println(new Solution().search(new int[]{3, 1}, 0));
//        System.out.println(new Solution().search(new int[]{3, 5, 1}, 1));
        System.out.println(new Solution().search(new int[]{3, 5, 1}, 5));
    }
}

package search_in_rotated_sorted_array_2;

import java.util.Arrays;

public class Solution {

    public boolean binarySearch(int[] nums, int start, int end, int target) {
        if (start > nums.length - 1) {
            return false;
        }
        if (start == end - 1 || start == end) {
            return nums[start] == target;
        }
        if (nums[start] < nums[end - 1]) {
            return Arrays.binarySearch(nums, start, end, target) >= 0;
        }

        int middle = (start + end) / 2;
        if (target == nums[middle]) {
            return true;
        } else {
            boolean leftHas = (nums[start] < nums[middle]) ?
                    Arrays.binarySearch(nums, start, middle, target) >= 0 :
                    binarySearch(nums, start, middle, target);

            boolean rightHas = (nums[middle] < nums[end - 1]) ?
                    Arrays.binarySearch(nums, middle + 1, end, target) >= 0 :
                    binarySearch(nums, middle + 1, end, target);
            return leftHas || rightHas;
        }
    }

    public boolean search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length, target);
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
//        System.out.println(new Solution().search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
//        System.out.println(new Solution().search(new int[]{1, 0, 1, 1, 1}, 0));
        System.out.println(new Solution().search(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1}, 2));
    }
}

package find_first_and_last_position_element_sorted_array;

import java.text.MessageFormat;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        return new int[]{binarySearchHead(nums, 0, nums.length - 1, target),
                binarySearchTail(nums, 0, nums.length - 1, target)};
    }

    protected int binarySearchHead(int[] nums, int start, int end, int target) {
        if (start == end) {
            if (nums[start] == target) {
                return (start == 0 || nums[start - 1] != nums[start]) ? start : -1;
            }
            return -1;
        }
        if (start == end - 1) {
            if (nums[start] == target) {
                return (start == 0 || nums[start - 1] != nums[start]) ? start : -1;
            } else if (nums[end] == target) {
                return end;
            } else {
                return -1;
            }
        }
        int middle = (start + end) / 2;
        if (nums[middle] >= target) {
            return binarySearchHead(nums, start, middle, target);
        } else {
            return binarySearchHead(nums, middle, end, target);
        }
    }

    protected int binarySearchTail(int[] nums, int start, int end, int target) {
        if (start == end) {
            if (nums[end] == target) {
                return (end == nums.length - 1 || nums[end + 1] != nums[end]) ? end : -1;
            }
            return -1;
        }
        if (start == end - 1) {
            if (nums[end] == target) {
                return (end == nums.length - 1 || nums[end + 1] != nums[end]) ? end : -1;
            } else if (nums[start] == target) {
                return start;
            } else {
                return -1;
            }
        }
        int middle = (start + end) / 2;
        if (nums[middle] <= target) {
            return binarySearchTail(nums, middle, end, target);
        } else {
            return binarySearchTail(nums, start, middle, target);
        }
    }

    public static void main(String[] args) {
        printResult(new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
        printResult(new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6));
        printResult(new Solution().searchRange(new int[]{}, 0));
    }

    protected static void printResult(int[] result) {
        System.out.println(MessageFormat.format("{0},{1}", result[0], result[1]));
    }
}

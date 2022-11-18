package find_peak_element;

public class Solution {

    int type(int[] nums, int index) {
        boolean leftup = index == 0 || nums[index - 1] < nums[index];
        boolean rightdown = index == nums.length - 1 || nums[index] > nums[index + 1];
        return (leftup ? 1 : 0) + (rightdown ? 0 : 2);
    }

    int search(int[] nums, int start, int end) {
        if (start == nums.length) {
            return -1;
        }
        int ts = type(nums, start);
        int te = type(nums, end);
        if (ts == 1) {
            return start;
        }
        if (te == 1) {
            return end;
        }
        int middle = (start + end) / 2;
        int tm = type(nums, middle);
        if (tm == 1) {
            return middle;
        }
        if (tm == 2 || tm == 0) {
            return search(nums, start, middle - 1);
        }
        if (tm == 3) {
            return search(nums, middle + 1, end);
        }
        throw new IllegalArgumentException();
    }

    public int findPeakElement(int[] nums) {
        if (nums.length < 2) {
            return nums.length - 1;
        }
        return search(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findPeakElement(new int[]{1, 2}));
    }
}

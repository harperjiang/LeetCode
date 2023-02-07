package rotate_function;

public class Solution {
    public int maxRotateFunction(int[] nums) {
        int start = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            start += i * nums[i];
            sum += nums[i];
        }
        int max = start;
        for (int i = 1; i < nums.length; i++) {
            int delta = (nums.length) * nums[i - 1] - sum;
            max = Math.max(max, start + delta);
            start += delta;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxRotateFunction(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }
}

package minimum_size_subarray_sum;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int fp = 0, lp = 0;
        int sum = 0;
        int minlen = Integer.MAX_VALUE;
        while (fp < nums.length && lp < nums.length) {
            while (lp < nums.length && sum < target) {
                sum += nums[lp];
                lp++;
            }
            if (lp == nums.length && sum < target) {
                break;
            }
            while (sum >= target) {
                minlen = Math.min(minlen, lp - fp);
                sum -= nums[fp];
                fp++;
            }
        }
        return minlen == Integer.MAX_VALUE ? 0 : minlen;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}

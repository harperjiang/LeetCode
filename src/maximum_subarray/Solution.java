package maximum_subarray;

public class Solution {
    public int maxSubArray(int[] nums) {
        int lp = 0;
        int maxsum = 0;
        int sum = 0;
        int maxnpelem = Integer.MIN_VALUE;
        while (lp < nums.length) {
            int current = nums[lp++];
            sum += current;
            if (sum <= 0) {// Already less than 0, do not choose
                sum = 0;
            }
            if (current <= 0) {
                maxnpelem = Math.max(current, maxnpelem);
            } else {
                maxsum = Math.max(maxsum, sum);
            }
        }
        return maxsum == 0 ? maxnpelem : maxsum;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
//        System.out.println(new Solution().maxSubArray(new int[]{-1}));
//        System.out.println(new Solution().maxSubArray(new int[]{0}));
        System.out.println(new Solution().maxSubArray(new int[]{1, 1, -2}));
    }
}

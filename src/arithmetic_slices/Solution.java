package arithmetic_slices;

public class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int lastdiff = -3000;
        int laststart = 0;
        int total = 0;
        for(int i = 1 ; i < nums.length; i++) {
            int diff = nums[i] - nums[i-1];
            if(diff != lastdiff) {
                int lastlen = i - 1 - laststart + 1;
                if(lastlen >= 3) {
                    total += lastlen * lastlen/2 - 3*lastlen/2 +1;
                }
                laststart = i - 1;
                lastdiff = diff;
            }
        }
        int lastlen = nums.length - laststart;
        if(lastlen >= 3) {
            total += lastlen * lastlen/2 - 3*lastlen/2 +1;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfArithmeticSlices(new int[]{1,2,3,8,9,10}));
    }
}

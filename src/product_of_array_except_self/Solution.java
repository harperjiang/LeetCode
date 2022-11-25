package product_of_array_except_self;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftup = new int[nums.length];
        int[] rightup = new int[nums.length];
        int leftp = 1;
        int rightp = 1;
        for (int i = 0; i < nums.length; ++i) {
            leftp *= nums[i];
            rightp *= nums[nums.length - 1 - i];
            leftup[i] = leftp;
            rightup[nums.length - 1 - i] = rightp;
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            int lefti = i == 0 ? 1 : leftup[i - 1];
            int righti = (i == nums.length - 1) ? 1 : rightup[i + 1];
            result[i] = lefti * righti;
        }
        return result;
    }

    public static void main(String[] args) {
        new Solution().productExceptSelf(new int[]{1, 2, 3, 4});
    }
}

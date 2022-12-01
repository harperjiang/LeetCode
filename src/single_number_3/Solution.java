package single_number_3;

public class Solution {
    public int[] singleNumber(int[] nums) {
        int[] buffer = new int[nums.length];
        int xors = 0;
        for (int i = 0; i < nums.length; ++i) {
            xors ^= nums[i];
        }
        int mask = xors & (-xors);
        int x = 0;
        for (int i = 0; i < nums.length; ++i) {
            if ((nums[i] & mask) != 0) {
                x ^= nums[i];
            }
        }
        return new int[]{x, xors ^ x};
    }
}

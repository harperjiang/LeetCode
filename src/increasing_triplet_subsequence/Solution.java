package increasing_triplet_subsequence;

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int[] buffer = new int[3];
        boolean[] valid = new boolean[3];
        valid[0] = true;
        buffer[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (valid[1] && buffer[1] < nums[i]) {
                return true;
            }
            if (buffer[0] < nums[i] && (!valid[1] || buffer[1] > nums[i])) {
                buffer[1] = nums[i];
                valid[1] = true;
            } else if (buffer[0] > nums[i]) {
                buffer[0] = nums[i];
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().increasingTriplet(new int[]{20, 100, 10, 12, 5, 13}));
        System.out.println(new Solution().increasingTriplet(new int[]{6, 7, 1, 2}));
    }
}

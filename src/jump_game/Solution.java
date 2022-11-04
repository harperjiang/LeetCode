package jump_game;

import java.util.Arrays;

public class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int max_jump = nums[0];
        for (int i = 1; i <= max_jump && i < nums.length; ++i) {
            if (nums[i] + i > max_jump) {
                max_jump = nums[i] + i;
            }
        }
        return max_jump >= nums.length-1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(new Solution().canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(new Solution().canJump(new int[]{0}));
        System.out.println(new Solution().canJump(new int[]{2, 0, 0}));
    }
}

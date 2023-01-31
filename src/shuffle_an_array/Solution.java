package shuffle_an_array;

import java.util.*;

public class Solution {

    int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int[] reset() {
        return nums;
    }

    Random r = new Random(System.currentTimeMillis());

    public int[] shuffle() {
        int[] result = new int[nums.length];
        System.arraycopy(nums, 0, result, 0, nums.length);

        for (int i = nums.length; i > 0; i--) {
            int next = r.nextInt(i);
            // Swap next and i-1
            if (next != i - 1) {
                int temp = result[next];
                result[next] = result[i - 1];
                result[i - 1] = temp;
            }
        }

        return result;
    }
}

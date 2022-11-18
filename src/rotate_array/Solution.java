package rotate_array;

public class Solution {

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int[] buffer = new int[k];
        System.arraycopy(nums, nums.length - k, buffer, 0, k);
        System.arraycopy(nums, 0, nums, k, nums.length - k);
        System.arraycopy(buffer, 0, nums, 0, k);
    }


}

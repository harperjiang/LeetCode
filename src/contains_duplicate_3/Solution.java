package contains_duplicate_3;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        for (int j = 1; j <= indexDiff; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (i + j < nums.length) {
                    if (Math.abs(nums[i] - nums[i+j]) <= valueDiff) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
    }

}

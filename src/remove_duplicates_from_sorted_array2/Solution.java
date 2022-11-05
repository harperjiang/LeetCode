package remove_duplicates_from_sorted_array2;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int fp = 0;
        int lp = 0;
        int counter = 0;
        while (counter < nums.length) {
            if (nums[fp] == nums[lp]) {
                lp++;
                counter++;
            } else {
                if (lp - fp > 2) {
                    System.arraycopy(nums, lp, nums, fp + 2, nums.length - lp);
                    lp = fp + 2;
                }
                fp = lp;
            }
        }
        if (lp - fp > 2) {
            lp = fp + 2;
        }
        return lp;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
        System.out.println(new Solution().removeDuplicates(new int[]{1, 1, 1, 1}));
    }
}

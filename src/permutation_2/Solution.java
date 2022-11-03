package permutation_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        run(nums, 0, results);
        return results;
    }

    protected void run(int[] nums, int i, List<List<Integer>> results) {
        if (i >= nums.length) {
            List<Integer> piece = new ArrayList<>();
            for (int num : nums)
                piece.add(num);
            results.add(piece);
            return;
        }
        int bitmap = 0;
        for (int j = i; j < nums.length; j++) {
            if ((bitmap & (1 << (nums[j] + 11))) != 0) {
                continue;
            }
            bitmap |= 1 << (nums[j] + 11);
            int temp;
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            run(nums, i + 1, results);
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().permuteUnique(new int[]{1, 1, 2}));
    }
}

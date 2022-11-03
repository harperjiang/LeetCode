package permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        run(nums, 0, results);
        return results;
    }

    protected void run(int[] nums, int idx, List<List<Integer>> results) {
        if (idx >= nums.length) {
            List<Integer> piece = new ArrayList<>();
            for(int n:nums) {
                piece.add(n);
            }
            results.add(piece);
            return;
        }
        for (int j = idx; j < nums.length; j++) {
            int temp = nums[idx];
            nums[idx] = nums[j];
            nums[j] = temp;
            run(nums, idx+1, results);
            temp = nums[idx];
            nums[idx] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().permute(new int[]{1, 2, 3}));
    }
}

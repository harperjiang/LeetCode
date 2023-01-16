package largest_divisible_subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    int scan(int[] nums, int[] next, int[] count, int viewidx) {
        if (count[viewidx] >= 0) {
            return count[viewidx];
        }
        int num = nums[viewidx];
        int midx = -1;
        int max = -1;
        for (int i = viewidx + 1; i < nums.length; i++) {
            if (nums[i] % num == 0) {
                int imax = count[i] + 1;
                if (imax > max) {
                    midx = i;
                    max = imax;
                }
            }
        }
        next[viewidx] = midx;
        count[viewidx] = max;
        return max;
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] next = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(next, -1);
        Arrays.fill(count, -1);
        int max = -1;
        int midx = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int imax = scan(nums, next, count, i);
            if (imax > max) {
                midx = i;
                max = imax;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = midx; i < nums.length && i >= 0; i = next[i]) {
            result.add(nums[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestDivisibleSubset(new int[]{1, 2, 3}));
        System.out.println(new Solution().largestDivisibleSubset(new int[]{1, 2, 4, 8}));
    }
}

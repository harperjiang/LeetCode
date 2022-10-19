package threesum;

import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        // Find first zero and last zero
        int fpzero = -1, lpzero = -1;
        Set<Integer> negs = new HashSet<>();
        Set<Integer> poss = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (fpzero == -1 && nums[i] == 0) {
                fpzero = i;
                lpzero = i;
            }
            if (nums[i] == 0 && i > lpzero) {
                lpzero = i;
            }
            if (nums[i] < 0) {
                negs.add(-nums[i]);
            }
            if (nums[i] > 0) {
                if (fpzero == -1) { // No zero
                    fpzero = i;
                    lpzero = fpzero - 1;
                }
                poss.add(nums[i]);
            }
        }
        // no pos or no negs
        if (fpzero <= 0 || lpzero == nums.length - 1) {
            return lpzero - fpzero >= 2 ? List.of(List.of(0, 0, 0)) : Collections.emptyList();
        }
        List<List<Integer>> results = new ArrayList<>();
        // Case 1, has zero, choose negative positive from both size and construct tuples
        if (fpzero > 0 && fpzero <= lpzero) {
            poss.forEach(i -> {
                if (negs.contains(i)) {
                    results.add(List.of(-i, 0, i));
                }
            });
        }
        // Case 2, do not use zero, choose left two and right one, can use sum two
        for (int i = 0; i < fpzero - 1; ++i) {
            // For groups of the same number, first compute if 2*i satisfies, then skip the group
            int j = i + 1;
            while (j < fpzero&& nums[j] == nums[i]) {
                j++;
            }
            if (j > i + 1) j--;

            if (nums[i] == nums[j]) {
                if (poss.contains(-2 * nums[i])) { // Record once and skip the group
                    results.add(List.of(nums[i], nums[i], -2 * nums[i]));
                }
                i = j;
            }

            for (int k = i + 1; k < fpzero; ++k) {
                if (poss.contains(-nums[i] - nums[k])) {
                    results.add(List.of(nums[i], nums[k], -nums[i] - nums[k]));
                }
                int current = nums[k];
                while (k < fpzero && nums[k] == current) {
                    k++;
                }
                if (k > i + 1) {
                    k--;
                }
            }
        }

        // Case 3, similar to case 2 but choose left one and right two
        for (int i = lpzero + 1; i < nums.length - 1; ++i) {
            // For groups of the same number, first compute if 2*i satisfies, then skip the group
            int j = i + 1;
            while (j < nums.length && nums[j] == nums[i]) {
                j++;
            }
            if (j > i + 1) j--;

            if (nums[i] == nums[j]) {
                if (negs.contains(2 * nums[i])) { // Record once and skip the group
                    results.add(List.of(-2 * nums[i], nums[i], nums[i]));
                }
                i = j;
            }
            for (int k = i + 1; k < nums.length; ++k) {
                if (negs.contains(nums[i] + nums[k])) {
                    results.add(List.of(-nums[i] - nums[k], nums[i], nums[k]));
                }
                int current = nums[k];
                while (k < nums.length && nums[k] == current) {
                    k++;
                }
                if (k > i + 1) {
                    k--;
                }
            }
        }
        // Case 4, if zero count is larger than 2, all zero tuples
        if (lpzero - fpzero >= 2) {
            results.add(List.of(0, 0, 0));
        }

        return results;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().threeSum(new int[]{3, 0, -2, -1, 1, 2}));
        System.out.println(new Solution().threeSum(new int[]{-3, 0, 2, 1, -1, -2}));
        System.out.println(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(new Solution().threeSum(new int[]{1, 1, -2}));
        System.out.println(new Solution().threeSum(new int[]{1, 2, -2, -1}));
        System.out.println(new Solution().threeSum(new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4}));
        System.out.println(new Solution().threeSum(new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6}));

    }
}

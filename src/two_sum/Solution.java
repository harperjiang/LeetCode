package two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> expecting = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int expect = target - nums[i];
            if (expecting.containsKey(nums[i])) {
                return new int[]{expecting.get(nums[i]), i};
            } else {
                expecting.put(target - nums[i], i);
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] test = new int[]{2, 7, 11, 5};
        int[] result = new Solution().twoSum(test, 9);
        System.out.println(Arrays.stream(result).mapToObj(i -> Integer.toString(i)).collect(Collectors.joining(",")));
    }
}
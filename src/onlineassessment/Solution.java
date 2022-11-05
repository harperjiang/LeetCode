package onlineassessment;

import java.util.*;

public class Solution {

    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> lookup = new HashMap<>();
        int[] cumsum = new int[nums.length];
        Arrays.fill(cumsum, 0);
        cumsum[0] = nums[0];
        lookup.put(cumsum[0],0);
        for (int i = 1; i < nums.length; i++) {
            cumsum[i] = cumsum[i - 1] + nums[i];
            lookup.put(cumsum[i], i);
        }
        int max = 0;
        if (lookup.containsKey(k)) {
            max = Math.max(max,lookup.get(k) + 1);
        }
        // Remove the
        for (int i = 0; i < nums.length; i++) {
            k += nums[i];
            if (lookup.containsKey(k)) {
                max = Math.max(max,lookup.get(k) - i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 3));
//        System.out.println(new Solution().maxSubArrayLen(new int[]{-1}, -1));
        System.out.println(new Solution().maxSubArrayLen(new int[]{1,1,0}, 1));
    }
}

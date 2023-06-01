package partition_equal_subset_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<Integer, int[]> buffer = new HashMap<>();

    boolean dfs(int[] nums, int start, int expect) {
        if (start == nums.length) return false;
        if (expect < 0) {
            return false;
        }
        if (expect == 0) {
            return true;
        }
        if (buffer.containsKey(expect)) {
            int[] ul = buffer.get(expect);
            if (ul[0] >= start) {
                return true;
            }
            if (ul[1] <= start) {
                return false;
            }
        }
        for (int i = start; i < nums.length; i++) {
            if (dfs(nums, i + 1, expect - nums[i])) {
                int newul0 = i;
                if (buffer.containsKey(expect)) {
                    int[] ul = buffer.get(expect);
                    if (ul[0] < newul0) {
                        ul[0] = newul0;
                        buffer.put(expect, ul);
                    }
                } else {
                    buffer.put(expect, new int[]{i, nums.length + 1});
                }
                return true;
            }
        }
        if (buffer.containsKey(expect)) {
            int[] ul = buffer.get(expect);
            if (ul[1] > start) {
                ul[1] = start;
                buffer.put(expect, ul);
            }
        } else {
            buffer.put(expect, new int[]{-1, start});
        }
        return false;
    }

    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) return false;
        int expect = sum / 2;

        int sum1 = 0;
        int sum2 = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (sum1 >= sum2) {
                sum2 += nums[i];
            } else {
                sum1 += nums[i];
            }
        }
        if (sum1 == sum2) return true;

        return dfs(nums, 0, expect);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canPartition(new int[]{
                100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 99, 97
        }));
    }
}

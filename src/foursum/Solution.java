package foursum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; ++i) {
            for (int j = i + 1; j < nums.length - 2; ++j) {
                {
                    long twotarget = (long)target - nums[i] - nums[j];
                    int low = j + 1;
                    int high = nums.length - 1;
                    while (low < high) {
                        if (nums[low] + nums[high] == twotarget) {
                            result.add(List.of(nums[i], nums[j], nums[low], nums[high]));
                            // Both side move to next not equal number
                            low++;
                            while (low < nums.length - 1 && nums[low - 1] == nums[low]) low++;
                            high--;
                            while (high >= 0 && nums[high + 1] == nums[high]) high--;
                        } else if (nums[low] + nums[high] < twotarget) low++;
                        else high--;
                    }
                }
                while (j < nums.length - 2 && nums[j + 1] == nums[j]) j++;
            }
            while (i < nums.length - 3 && nums[i + 1] == nums[i]) i++;
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
//        System.out.println(new Solution().fourSum(new int[]{-2, -1, -1, 1, 1, 2, 2}, 0));
        System.out.println(new Solution().fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296));
    }
}

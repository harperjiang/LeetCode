package majority_element;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }
        if (nums.length == 1) {
            return List.of(nums[0]);
        }
        if (nums.length == 2) {
            return nums[0] == nums[1] ? List.of(nums[0]) : List.of(nums[0], nums[1]);
        }
        Arrays.sort(nums);
        int counter = 1;
        int threshold = nums.length / 3;
        List<Integer> result = new ArrayList<>();
        for (int pointer = 1; pointer < nums.length; pointer++) {
            if (nums[pointer - 1] == nums[pointer]) {
                counter++;
            } else {
                if (counter > threshold) {
                    result.add(nums[pointer-1]);
                    if (result.size() == 2) {
                        return result;
                    }
                }
                counter = 1;
            }
        }
        if (counter > threshold) {
            result.add(nums[nums.length - 1]);
            if (result.size() == 2) {
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().majorityElement(new int[]{3, 3, 4}));
    }
}

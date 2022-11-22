package majority_element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a solution of linear time and O(1) space
 */
public class Solution2 {

    void linear_group(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < nums[i - 1]) {
                int temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
            }
        }
    }

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
        linear_group(nums);
        int counter = 1;
        int threshold = nums.length / 3;
        List<Integer> result = new ArrayList<>();
        for (int pointer = 1; pointer < nums.length; pointer++) {
            if (nums[pointer - 1] == nums[pointer]) {
                counter++;
            } else {
                if (counter > threshold) {
                    result.add(nums[pointer - 1]);
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
        new Solution2().majorityElement(new int[]{3, 2, 3, 2, 1, 3, 4});
    }
}

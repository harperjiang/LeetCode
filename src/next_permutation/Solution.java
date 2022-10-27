package next_permutation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public void nextPermutation(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            int check = nums.length - 1 - i;
            int num = nums[check];
            if (num < nums[check + 1]) {
                Arrays.sort(nums, check, nums.length);
                int index = Arrays.binarySearch(nums, check, nums.length, num);
                int index_next = index + 1;
                while (nums[index_next] == num) {
                    index_next++;
                }
                int next = nums[index_next];
                System.arraycopy(nums, check, nums, check + 1, index_next - check);
                nums[check] = next;
                return;
            }
        }
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 2, 0, 2, 3, 2, 0};
        new Solution().nextPermutation(array);
        System.out.println(Arrays.stream(array).mapToObj(i -> String.valueOf(i)).collect(Collectors.joining(",")));
    }
}

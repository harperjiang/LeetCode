package two_sum_2_input_array_is_sorted;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int fp = 0, lp = numbers.length - 1;
        while (fp < lp) {
            int current = numbers[fp] + numbers[lp];
            if (current == target) {
                return new int[]{fp + 1, lp + 1};
            }
            if (current > target) {
                lp--;
            } else {
                fp++;
            }
        }
        throw new IllegalArgumentException();
    }
}

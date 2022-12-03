package find_the_duplicate_number;

public class Solution {
    public int findDuplicate(int[] nums) {
        int[] bits = new int[32];
        int[] should = new int[32];

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                should[j] += (i & (1 << j)) != 0 ? 1 : 0;
            }
        }

        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                bits[i] += (num & (1 << i)) != 0 ? 1 : 0;
            }
        }
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            if (bits[i] > should[i])
                sum += (1 << i);
        }
        return sum;
    }

    public static void main(String[] args) {
        new Solution().findDuplicate(new int[]{2, 2, 2, 2, 2});
    }
}

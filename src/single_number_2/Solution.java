package single_number_2;

import java.util.Arrays;

public class Solution {

    void to_bits(int[] buffer, int num) {
        for (int i = 0; i < 32; ++i) {
            buffer[i] = ((1 << i) & num) != 0 ? 1 : 0;
        }
    }

    int from_trinary(int[] tsum) {
        int sum = 0;
        for (int i = 0; i < 32; ++i) {
            sum += (tsum[i] % 3) << i;
        }
        return sum;
    }

    public int singleNumber(int[] nums) {
        int[] buffer = new int[32];
        int[] tsum = new int[32];
        for (int num : nums) {
            to_bits(buffer, num);
            for (int i = 0; i < buffer.length; ++i) {
                tsum[i] = (tsum[i] + buffer[i]);
            }
        }
        return from_trinary(tsum);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().singleNumber(new int[]{-2,-2,1,1,4,1,4,4,-4,-2}));
    }
}

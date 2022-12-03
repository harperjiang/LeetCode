package ugly_number_2;

import java.util.*;

public class Solution {
    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        int c2 = 0, c3 = 0, c5 = 0;
        for (int i = 1; i < n; ++i) {
            int c2n = nums[c2] * 2;
            int c3n = nums[c3] * 3;
            int c5n = nums[c5] * 5;
            nums[i] = Math.min(c2n, Math.min(c3n, c5n));
            if (nums[i] == c2n) c2++;
            if (nums[i] == c3n) c3++;
            if (nums[i] == c5n) c5++;
        }
        return nums[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().nthUglyNumber(10));
    }
}

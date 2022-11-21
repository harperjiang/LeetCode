package bitwise_and_of_numbers_range;

public class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int result = 0xFFFFFFFF;
        int init = left & right;
        int gap = right - left;
        for (int i = 0; i < 32; ++i) {
            int topmask = 1 << i;
            if((init &topmask)==0) {
                result ^= topmask;
                continue;
            }
            int mask = i == 31 ? -1 : (1 << (i + 1) - 1);
            if (gap >= topmask) {
                result ^= topmask;
                continue;
            }
            int ls = mask & left;
            int rs = mask & right;
            if (((ls & rs) & topmask) == 0) {
                result ^= topmask;
                continue;
            }
        }
        return result;
    }
}

package factorial_trailing_zeros;

import java.math.BigDecimal;

public class Solution {

    public int trailingZeroes(int n) {
        int numzeros = 0;

        int base = 5;

        while (base <= n) {
            numzeros += n / base;
            base *= 5;
        }

        return numzeros;
    }

    public static void main(String[] args) {
        int x = 80;
        System.out.println(new Solution().trailingZeroes(x));
        BigDecimal val = BigDecimal.ONE;
        for (int i = 1; i <= x; ++i) {
            val = val.multiply(new BigDecimal(i));
        }
        System.out.println(val.toPlainString());
    }
}

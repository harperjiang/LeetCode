package pow_x_n;

public class Solution {
    public double myPow(double x, int n) {
        if (n > 0) {
            double res = 1;
            double pow = x;
            for (int i = 0; i < 32; ++i) {
                if ((n & (1 << i)) != 0) {
                    res *= pow;
                }
                pow *= pow;
            }
            return res;
        } else if (n == 0x80000000) {
            return 1 / myPow(x, 0x7fffffff) / x;
        }
        if (n < 0) {
            return 1 / myPow(x, -n);
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myPow(2, 10));
    }
}

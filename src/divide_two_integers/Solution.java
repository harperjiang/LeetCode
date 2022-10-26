package divide_two_integers;

public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == divisor) {
            return 1;
        }
        if (divisor == 0x80000000) {
            return 0;
        }
        int negdivident = dividend < 0 ? dividend : -dividend;
        int posdivisor = divisor > 0 ? divisor : -divisor;
        if (negdivident > -posdivisor) {
            return 0;
        }
        int baselimit = 32;
        int baseprobe = posdivisor;
        while (baseprobe != 0) {
            baselimit--;
            baseprobe >>= 1;
        }
        int result = 0;
        while (negdivident <= -posdivisor) {
            int base = 0;
            while (base < baselimit && -(posdivisor << base) > negdivident) {
                base++;
            }
            if (-(posdivisor << base) == negdivident) {
                result += (1 << base);
                break;
            } else {
                result += 1 << (base - 1);
                negdivident += posdivisor << (base - 1);
            }
        }
        if (result == 0x80000000) {
            result = ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) ? 0x7FFFFFFF : 0x80000000;
        } else {
            result *= ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) ? 1 : -1;
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().divide(10, 3));
//        System.out.println(new Solution().divide(7, -3));
        System.out.println(new Solution().divide(-2147483648, -1));
    }
}

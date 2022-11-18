package fraction_to_recurring_decimal;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        if (denominator == 1) {
            return String.valueOf(numerator);
        }
        long ln = numerator;
        long ld = denominator;
        boolean neg = (numerator < 0) != (denominator < 0);
        StringBuilder result = new StringBuilder();
        if (neg) {
            result.append("-");
        }
        if (ln < 0) {
            ln = -ln;
        }
        if (ld < 0) {
            ld = -ld;
        }
        Map<Long, Integer> appeared = new HashMap<>();

        // Integer part
        result.append(ln / ld);

        long leftover = ln % ld;
        if (leftover == 0) {
            return result.toString();
        }
        result.append(".");
        StringBuilder buffer = new StringBuilder();

        int loopc = 0;
        while (leftover != 0) {
//            System.out.println(leftover);
            if (appeared.containsKey(leftover)) {
                int pos = appeared.get(leftover);
                result.append(buffer.substring(0, pos)).append("(").append(buffer.substring(pos)).append(")");
                return result.toString();
            }
            appeared.put(leftover, loopc++);
            leftover *= 10;
            if (leftover < ld) {
                buffer.append("0");
            } else {
                buffer.append(leftover / ld);
                leftover %= ld;
            }
        }
        result.append(buffer);
        return result.toString();
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().fractionToDecimal(1, 214748364));
//        System.out.println(new Solution().fractionToDecimal(-1, -2147483648));
        System.out.println(new Solution().fractionToDecimal(-2147483648, 1));
//        System.out.println(new Solution().fractionToDecimal(1, 6));
//        System.out.println(new Solution().fractionToDecimal(-50, 8));
    }
}

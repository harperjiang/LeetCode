package multiply_strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 456
// 123
//   1368
//    120
//  10488
//  456
// 56088
public class Solution {
    public String multiply(String num1, String num2) {
        int[] buffer = new int[num1.length() + num2.length()];
        Arrays.fill(buffer, 0);

        for (int i = num1.length() - 1; i >= 0; i--) {
            int di = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int dj = num2.charAt(j) - '0';
                buffer[i + j + 1] += di * dj;
                buffer[i + j] += buffer[i + j + 1] / 10;
                buffer[i + j + 1] %= 10;
                if (i + j > 0) {
                    buffer[i + j - 1] += buffer[i + j] / 10;
                    buffer[i + j] %= 10;
                }
            }
        }
        boolean nz = false;
        StringBuilder builder = new StringBuilder();
        for (int i : buffer) {
            if (i == 0) {
                if (nz) {
                    builder.append(i);
                } else {
                    continue;
                }
            } else {
                nz = true;
                builder.append(i);
            }
        }
        if (builder.length() == 0) {
            return "0";
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().multiply("2", "3"));
        System.out.println(new Solution().multiply("123", "456"));
        System.out.println(new Solution().multiply("0", "0"));
        System.out.println(new Solution().multiply("9", "9"));
        System.out.println(new Solution().multiply("9131", "0"));
        System.out.println(new Solution().multiply("0", "1313"));
    }
}

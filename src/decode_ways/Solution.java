package decode_ways;

import java.util.Arrays;

public class Solution {

    public int numDecodings(String s) {
        if (s.length() == 1) {
            return s.charAt(0) == '0' ? 0 : 1;
        }
        int[] buffer = new int[s.length()];

        buffer[s.length() - 1] = s.charAt(s.length() - 1) == '0' ? 0 : 1;
        buffer[s.length() - 2] = 0;
        if (s.charAt(s.length() - 2) != '0') {
            buffer[s.length() - 2] = buffer[s.length() - 1];
            if (((s.charAt(s.length() - 2) - '0') * 10) + s.charAt(s.length() - 1) - '0' <= 26) {
                buffer[s.length() - 2] += 1;
            }
        }
        for (int i = s.length() - 3; i >= 0; i--) {
            buffer[i] = 0;
            if (s.charAt(i) != '0') {
                buffer[i] += buffer[i + 1];
                if (((s.charAt(i) - '0') * 10) + s.charAt(i + 1) - '0' <= 26) {
                    buffer[i] += buffer[i + 2];
                }
            }
        }

        return buffer[0];
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().numDecodings("111111111111111111111111111111111111111111111"));
        System.out.println(new Solution().numDecodings("06"));
        System.out.println(new Solution().numDecodings("27"));
        System.out.println(new Solution().numDecodings("2101"));
    }
}

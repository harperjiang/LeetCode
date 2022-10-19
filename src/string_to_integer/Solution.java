package string_to_integer;

public class Solution {
    public int myAtoi(String s) {
        int sum = 0;
        boolean negative = false;
        int state = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            switch (state) {
                case 0: // begin, accept '+','-', and number
                    if (c == '-') {
                        negative = true;
                        state = 1;
                    } else if (c == '+') {
                        negative = false;
                        state = 1;
                    } else if (c == ' ') {

                    } else if (c == '0') {
                        state = 1;
                    } else if (c > '0' && c <= '9') {
                        sum += c - '0';
                        state = 1;
                    } else {
                        return 0;
                    }
                    break;
                case 1:
                    if (c >= '0' && c <= '9') {
                        int newsum = sum * 10 + c - '0';
                        if (sum != (newsum / 10)) { // Overflow
                            return negative ? 0x80000000 : 0x7FFFFFFF;
                        } else {
                            sum = newsum;
                        }
                    } else {
                        return sum * (negative ? -1 : 1);
                    }
                    break;
                default:
                    break;
            }
        }
        return sum * (negative ? -1 : 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi("-91283472332"));
    }
}

package additive_number;

public class Solution {

    boolean verify(long first, long second, String num, int startIndex) {
        int pointer = startIndex;
        while (pointer < num.length()) {
            long next = first + second;
            String nextstr = String.valueOf(next);
            if (pointer + nextstr.length() > num.length()) {
                return false;
            }
            for (int i = 0; i < nextstr.length(); i++) {
                if (num.charAt(pointer + i) != nextstr.charAt(i)) {
                    return false;
                }
            }
            pointer += nextstr.length();
            first = second;
            second = next;
        }
        return true;
    }

    public boolean isAdditiveNumber(String num) {
        for (int i = 1; i < num.length(); i++) {
            Long first = Long.valueOf(num.substring(0, i));
            for (int j = i + 1; j < num.length(); j++) {
                long second = Long.valueOf(num.substring(i, j));
                if (verify(first, second, num, j)) {
                    return true;
                }
                if (second == 0) {
                    break;
                }
            }
            if (first == 0) {
                break;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isAdditiveNumber("1023"));
        System.out.println(new Solution().isAdditiveNumber("101"));
        System.out.println(new Solution().isAdditiveNumber("198019823962"));
    }
}

package palindrome_number;

public class Solution {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int length = (int) Math.ceil(Math.log10(x));
        int sum = 0;
        for (int i = 0; i < length / 2; ++i) {
            int digit = x % 10;
            x /= 10;
            sum = sum * 10 + digit;
        }
        return length % 2 == 1 ? sum == x / 10 : sum == x;
    }

    public static void main(String[] s) {
        System.out.println(new Solution().isPalindrome(11));
        System.out.println(new Solution().isPalindrome(121));
        System.out.println(new Solution().isPalindrome(1331));
        System.out.println(new Solution().isPalindrome(1431));
        System.out.println(new Solution().isPalindrome(14231));
    }
}

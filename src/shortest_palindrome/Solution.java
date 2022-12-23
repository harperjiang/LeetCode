package shortest_palindrome;

public class Solution {

    char charAt(String s, int i) {
        if (i == s.length()) {
            return 0;
        }
        return i > s.length() ? s.charAt(s.length() - (i - s.length())) : s.charAt(i);
    }

    public String shortestPalindrome(String s) {
        if (s.length() == 0) {
            return s;
        }
        int[] kmpbuffer = new int[2 * s.length() + 1];

        for (int i = 1; i < 2 * s.length() + 1; i++) {
            int t = kmpbuffer[i - 1];
            int cati = charAt(s, i);
            if (charAt(s, t) == cati) {
                kmpbuffer[i] = t + 1;
            } else {
                while (t > 0 && charAt(s, t) != cati) {
                    t = kmpbuffer[t - 1];
                }
                if (charAt(s, t) == cati) {
                    kmpbuffer[i] = t + 1;
                } else {
                    kmpbuffer[i] = 0;
                }
            }
            // S is a palindrome itself
            if (i == s.length() && kmpbuffer[i] == s.length()) {
                return s;
            }
        }
        int pandlength = kmpbuffer[kmpbuffer.length - 1];
        StringBuilder builder = new StringBuilder();
        for (int i = s.length() - 1; i >= pandlength; i--) {
            builder.append(s.charAt(i));
        }
        builder.append(s);
        return builder.toString();
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().shortestPalindrome("aacecaaa"));
//        System.out.println(new Solution().shortestPalindrome("aba"));
        System.out.println(new Solution().shortestPalindrome("aabba"));
//        System.out.println(new Solution().shortestPalindrome("aaaaa"));
    }
}

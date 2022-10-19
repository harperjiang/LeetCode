package longest_palindromic_substring;

class Solution {
    public String longestPalindrome(String s) {
        int max = 1;
        int maxPos = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                // Search for even palindromic
                int evenext = 2;
                int esl = Integer.min(i, s.length() - 1 - i - 1);
                for (int idx = 1; idx < esl; idx++) {
                    if (s.charAt(i - idx) == s.charAt(i + 1 + idx)) {
                        evenext += 2;
                    } else {
                        break;
                    }
                }
                max = Integer.max(max, evenext);
            }
            // Search for odd palindromic
            int searchLen = Integer.min(i, s.length() - 1 - i);
            int extend = 1;
            for (int idx = 1; idx < searchLen; idx++) {
                if (s.charAt(i - idx) == s.charAt(i + idx)) {
                    extend += 2;
                } else {
                    break;
                }
            }
            max = Integer.max(extend, max);
        }
        return "";
    }
}

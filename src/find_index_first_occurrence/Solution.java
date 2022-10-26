package find_index_first_occurrence;

public class Solution {
    public int strStr(String haystack, String needle) {
        int[] lp = kmp(needle);
        int i = 0;
        int j = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == needle.length()) {
                    return i - needle.length();
                }
            } else {
                if (j != 0) {
                    j = lp[j - 1];
                } else {
                    i += 1;
                }
            }
        }
        return -1;
    }

    protected int[] kmp(String input) {
        int[] lps = new int[input.length()];
// length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < input.length()) {
            if (input.charAt(i) == input.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (len != 0) {
                    len = lps[len - 1];

                    // Also, note that we do not increment
                    // i here
                } else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().strStr("sadbutsad", "sad"));
//        System.out.println(new Solution().strStr("leetcode", "leeto"));
        System.out.println(new Solution().strStr("hello", "ll"));
    }
}
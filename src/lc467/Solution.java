package lc467;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int findSubstringInWraproundString(String s) {
        int n = s.length();

        int[] longest = new int[26];
        int counter = 0;

        int start = 0;
        for (int i = 1; i < n; i++) {
            if (!(s.charAt(i) == s.charAt(i - 1) + 1 || (s.charAt(i) == 'a' && s.charAt(i - 1) == 'z'))) {
                // Record longest
                int index = s.charAt(i - 1) - 'a';
                longest[index] = Math.max(longest[index], i - 1 - start + 1);
                start = i;
            }
        }
        int index = s.charAt(n - 1) - 'a';
        longest[index] = Math.max(longest[index], n - 1 - start + 1);

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (i != j) {
                    int diff = i - j;
                    while (diff < 0) diff += 26;
                    longest[j] = Math.max(longest[j], longest[i] - diff);
                }
            }
        }

        for(int i = 0 ; i < 26;i++) {
            counter += longest[i];
        }

        return counter;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findSubstringInWraproundString("cac"));
        System.out.println(new Solution().findSubstringInWraproundString("zab"));
        System.out.println(new Solution().findSubstringInWraproundString("aabb"));

    }
}

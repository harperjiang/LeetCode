package longest_substring_with_at_least_k_repeating;

import java.util.Arrays;

public class Solution {
    public int longestSubstring(String s, int k) {
        int[] counter = new int[26];
        int uniqueCounter = 0;
        for (char c : s.toCharArray()) {
            counter[c - 'a']++;
            if (counter[c - 'a'] == 1) {
                uniqueCounter++;
            }
        }
        int maxLength = 0;
        for (int uc = 1; uc <= uniqueCounter; uc++) {
            Arrays.fill(counter, 0);
            int currentuc = 0;

            int start = 0;
            int end = 0;
            int bitmap = 0xFFFFFFFF;
            while (end < s.length()) {
                if (currentuc <= uc) {
                    int echar = s.charAt(end++) - 'a';
                    counter[echar]++;
                    if (counter[echar] == 1) {
                        currentuc++;
                    }
                    if (counter[echar] > 0 && counter[echar] < k) {
                        bitmap &= ~(1 << echar);
                    } else {
                        bitmap |= (1 << echar);
                    }
                } else {
                    int schar = s.charAt(start++) - 'a';
                    counter[schar]--;
                    if (counter[schar] == 0) {
                        currentuc--;
                    }
                    if (counter[schar] > 0 && counter[schar] < k) {
                        bitmap &= ~(1 << schar);
                    } else {
                        bitmap |= (1 << schar);
                    }
                }
                if (bitmap == 0xFFFFFFFF) {
                    maxLength = Math.max(maxLength, end - start);
                }
            }
        }
        return maxLength;
    }
}

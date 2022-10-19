package longest_substring_without_repeating;

import java.util.Arrays;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1)
            return s.length();
        int max = 0;
        int cmCounter = 0;
        int charMap[] = new int[256];
        int counter[] = new int[s.length()];
        Arrays.fill(charMap, -1);
        int left = 0, right = 0;
        while (right < s.length()) {
            boolean dup = false;
            // Extend right to max
            while (right < s.length()) {
                int index = charMap[s.charAt(right)];
                if (index == -1) {
                    charMap[s.charAt(right)] = cmCounter++;
                    index = cmCounter - 1;
                }
                counter[index]++;
                right++;
                if (counter[index] > 1) {
                    //duplicate
                    dup = true;
                    break;
                }
            }
            max = Integer.max(max, right - left - (dup ? 1 : 0));

            // Shrink left until all nodes are not duplicate
            while (left < right) {
                int index = charMap[s.charAt(left)];
                counter[index]--;
                left++;
                if (counter[index] == 1) {
                    // No more duplicate
                    break;
                }
            }
        }
        return max;
    }
}

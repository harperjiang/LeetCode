package longest_substrings_with_atmost_two_distinct_chars;

public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        char char1 = 0;
        char char2 = 0;
        char prev = 0;
        int char1prev = -1;
        int char2prev = -1;
        int laststart = -1;
        int max = -1;
        int counter = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);

            if (char1 == 0 || char2 == 0 || c == char1 || c == char2) { // increase counter
                if (char1 == 0) {
                    char1 = c;
                    char1prev = i;
                } else if (c == char1) {
                    char1prev = i;
                } else if (char2 == 0) {
                    char2 = c;
                    char2prev = i;
                } else if (c == char2) {
                    char2prev = i;
                }
                counter++;
            } else {//need to replace a char
                // First update max
                max = Math.max(counter, max);
                if (char1prev < char2prev) {//replace char1
                    char1 = c;
                    char1prev = i;
                    counter = i - laststart;
                } else {
                    char2 = c;
                    char2prev = i;
                    counter = i - laststart;
                }
                counter += 1;
            }
            if (prev == 0) {
                laststart = 0;
            } else {
                if (c != prev) {
                    laststart = i;
                }
            }
            prev = c;
        }
        max = Math.max(counter, max);
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstringTwoDistinct("abaccc"));
    }
}

package scramble_string;

/**
 * Created by harper on 10/14/17.
 */
class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        if (s1.equals(s2))
            return true;
        if(s1.length()==1)
            return false;
        // same set of characters
        int[] chars = new int[26];
        for (char c : s1.toCharArray()) {
            chars[c - 'a']++;
        }
        for (char c : s2.toCharArray()) {
            chars[c - 'a']--;
        }
        for (int val : chars)
            if (val != 0)
                return false;

        // Recursively
        for (int i = 1; i <= s1.length() - 1; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
                return true;
            if (isScramble(s1.substring(0, i), s2.substring(s1.length() - i)) && isScramble(s1.substring(i), s2.substring(0, s1.length() - i)))
                return true;
        }
        return false;
    }

}

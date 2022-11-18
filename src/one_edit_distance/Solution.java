package one_edit_distance;

public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int lengthdiff = s.length() - t.length();
        if (lengthdiff >= 2 || lengthdiff <= -2) {
            return false;
        }
        int diffcount = 0;
        if (lengthdiff == 0) {// There has to be exactly one different char
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    diffcount++;
                }
                if (diffcount > 1) {
                    return false;
                }
            }
            if (diffcount == 0) {
                return false;
            }
            return true;
        }
        // Now check insertion
        String shortone = s.length() < t.length() ? s : t;
        String longone = shortone == s ? t : s;
        int i = 0, j = 0;
        while (i < shortone.length()) {
            if (shortone.charAt(i) != longone.charAt(j)) {
                if (j == i) {
                    j += 1;
                    continue;
                } else {
                    return false;
                }
            }
            i++;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isOneEditDistance("ab", "acd"));
    }
}

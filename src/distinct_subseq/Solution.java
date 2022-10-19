package distinct_subseq;

/**
 * Created by harper on 10/15/17.
 */
class Solution {
    public int numDistinct(String s, String t) {
        int buffer[] = new int[t.length() + 1];

        buffer[0] = 1;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = t.length(); j >= 1; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    buffer[j] += buffer[j - 1];
                }
            }
        }
        return buffer[t.length()];
    }
}

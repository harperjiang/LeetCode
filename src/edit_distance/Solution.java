package edit_distance;

/**
 * Created by harper on 10/14/17.
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0)
            return word2.length();
        if (word2.length() == 0)
            return word1.length();
        int buffer1[] = new int[word2.length() + 1];
        int buffer2[] = new int[word2.length() + 1];
        for (int i = 0; i <= word2.length(); i++) {
            buffer1[i] = i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            buffer2[0] = buffer1[0] + 1;
            for (int j = 1; j <= word2.length(); j++) {
                buffer2[j] = Integer.min(buffer1[j] + 1, buffer2[j - 1] + 1);
                // equal
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    buffer2[j] = Integer.min(buffer1[j - 1], buffer2[j]);
                } else {
                    buffer2[j] = Integer.min(buffer1[j - 1] + 1, buffer2[j]);
                }
            }
            System.arraycopy(buffer2, 0, buffer1, 0, word2.length() + 1);
        }
        return buffer2[word2.length()];
    }
}

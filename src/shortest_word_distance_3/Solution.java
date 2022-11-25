package shortest_word_distance_3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        if (word1.compareTo(word2) == 0) {
            int lastpos = -1;
            for (int i = 0; i < wordsDict.length; i++) {
                String word = wordsDict[i];

                if (word.compareTo(word1) == 0) {
                    if (lastpos == -1) {
                        lastpos = i;
                    } else {
                        min = Math.min(min, i - lastpos);
                        lastpos = i;
                    }
                }
            }
        } else {
            int lastpos1 = -1;
            int lastpos2 = -1;
            for (int i = 0; i < wordsDict.length; i++) {
                String word = wordsDict[i];
                if (word.compareTo(word1) == 0) {
                    if (lastpos1 == -1) {
                        lastpos1 = i;
                    }
                    if (lastpos2 != -1) {
                        min = Integer.min(Math.abs(i - lastpos2), min);
                    }
                    lastpos1 = i;
                }
                if (word.compareTo(word2) == 0) {
                    if (lastpos2 == -1) {
                        lastpos2 = i;
                    }
                    if (lastpos1 != -1) {
                        min = Integer.min(Math.abs(i - lastpos1), min);
                    }
                    lastpos2 = i;
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        new Solution().shortestWordDistance(new String[]{"a", "c", "a", "b"}, "a", "b");
    }
}

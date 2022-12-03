package h_index;

import java.util.Arrays;

public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int pointer = citations.length - 1;
        if (citations[pointer] == 0) {
            return 0;
        }
        int h = 0;
        while (pointer >= 0 && citations[pointer] > h) {
            pointer--;
            h++;
        }

        return h;
    }
}

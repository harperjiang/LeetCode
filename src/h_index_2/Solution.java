package h_index_2;

public class Solution {
    public int hIndex(int[] citations) {
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

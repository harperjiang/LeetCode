package sentence_screen_fitting;

import java.util.Arrays;

public class Solution {
    int counter = 0;
    int[][] buffer;

    int fitrow(String[] sentence, int cols, int start) {
        if (buffer[start] != null) {
            int[] cached = buffer[start];
            counter += cached[1];
            return cached[0];
        }
        int cached_counter = counter;
        int pos_pointer = 0;
        int word_pointer = start;
        while (pos_pointer < cols) {
            pos_pointer += sentence[word_pointer++].length();

            if (pos_pointer < cols)
                pos_pointer++;
            else if (pos_pointer > cols) {
                word_pointer--;
                break;
            }

            if (word_pointer == sentence.length) {
                word_pointer = 0;
                counter++;
            }
        }

        buffer[start] = new int[]{word_pointer, counter - cached_counter};
        return buffer[start][0];
    }

    public int wordsTyping(String[] sentence, int rows, int cols) {
        int last = 0;
        counter = 0;
        buffer = new int[sentence.length][];
        for (int i = 0; i < rows; i++) {
            last = fitrow(sentence, cols, last);
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().wordsTyping(new String[]{"f", "p", "a"}, 8, 7));
    }
}

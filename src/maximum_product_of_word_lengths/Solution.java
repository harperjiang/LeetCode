package maximum_product_of_word_lengths;

public class Solution {
    public int maxProduct(String[] words) {
        int[] bitmaps = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int bitmap = 0;
            for (char c : word.toCharArray()) {
                bitmap |= 1 << (int) (c - 'a');
            }
            bitmaps[i] = bitmap;
        }
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((bitmaps[i] & bitmaps[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }
}

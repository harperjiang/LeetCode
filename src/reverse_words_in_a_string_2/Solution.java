package reverse_words_in_a_string_2;

public class Solution {

    void reverse(char[] s, int start, int end) {
        int length = (end - start) / 2;
        for (int i = 0; i < length; ++i) {
            char temp = s[start + i];
            s[start + i] = s[end - 1 - i];
            s[end - 1 - i] = temp;
        }
    }

    public void reverseWords(char[] s) {
        reverse(s, 0, s.length);
        int start = 0;
        int i = 0;
        while (i < s.length) {
            if (s[i] == ' ') {
                reverse(s, start, i);
                start = i;
                while (s[start] == ' ') start++;
                i = start;
            } else {
                i++;
            }
        }
        reverse(s, start, s.length);
    }
}

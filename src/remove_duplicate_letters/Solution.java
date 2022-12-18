package remove_duplicate_letters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastappear = new int[26];
        Arrays.fill(lastappear, -1);

        for (int i = 0; i < s.length(); i++) {

            char e = s.charAt(s.length() - 1 - i);
            int eindex = e - 'a';
            if (lastappear[eindex] == -1) {
                lastappear[eindex] = s.length() - 1 - i;
            }
        }

        StringBuilder builder = new StringBuilder();
        List<Integer> buffer = new ArrayList<>();
        boolean[] appear = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            int cindex = c - 'a';
            if (appear[cindex]) { // Already output
                continue;
            }

            while (!buffer.isEmpty()) {
                int last = buffer.get(buffer.size() - 1);
                if (last > cindex && lastappear[last] > i) {
                    buffer.remove(buffer.size() - 1);
                    appear[last] = false;
                } else {
                    break;
                }
            }
            buffer.add(cindex);
            appear[cindex] = true;
        }

        for (int i : buffer) {
            builder.append((char) ('a' + i));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicateLetters("bcabc"));
        System.out.println(new Solution().removeDuplicateLetters("cbacdcbc"));
        System.out.println(new Solution().removeDuplicateLetters("cdadabcc"));
    }
}

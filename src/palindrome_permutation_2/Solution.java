package palindrome_permutation_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    void dfs(List<String> result, char[] buffer, int[] counter, int pos) {
        if (pos >= buffer.length / 2) {
            result.add(new String(buffer));
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (counter[i] != 0) {
                buffer[pos] = (char) (i + 'a');
                buffer[buffer.length - 1 - pos] = (char) (i + 'a');
                counter[i] -= 2;
                dfs(result, buffer, counter, pos + 1);
                counter[i] += 2;
            }
        }
    }

    public List<String> generatePalindromes(String s) {
        int[] counter = new int[26];
        for (char c : s.toCharArray()) {
            counter[c - 'a']++;
        }
        int oddcount = 0;
        int oddindex = -1;
        for (int i = 0; i < 26; i++) {
            int c = counter[i];
            if (c % 2 == 1) {
                oddcount++;
                oddindex = i;
            }
            if (oddcount > 1) {
                return Collections.emptyList();
            }
        }
        char[] buffer = new char[s.length()];
        if (oddindex != -1) {
            buffer[s.length() / 2] = (char) (oddindex + 'a');
            counter[oddindex]--;
        }
        List<String> result = new ArrayList<>();

        dfs(result, buffer, counter, 0);

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generatePalindromes("aabb"));
    }
}

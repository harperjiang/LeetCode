package palindrome_partitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    boolean isPalindrome(String s, int fp, int lp) {
        while (fp < lp) {
            if (s.charAt(fp) == s.charAt(lp)) {
                fp++;
                lp--;
            } else {
                return false;
            }
        }
        return true;
    }

    void dfs(String s, List<List<String>> result, List<String> path, int pointer) {
        if (pointer == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        // Find next palindrome
        // Single letter is definitely one
        for (int i = pointer; i < s.length(); i++) {
            if (isPalindrome(s, pointer, i)) {
                path.add(s.substring(pointer, i + 1));
                dfs(s, result, path, i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(s, result, path, 0);
        return result;
    }
}

package palindrome_pairs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {

        HashMap<String, Integer> cache = new HashMap<>();
        TreeSet<Integer> lengths = new TreeSet<>();

        for (int i = 0; i < words.length; i++) {
            cache.put(words[i], i);
            lengths.add(words[i].length());
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            // Reverse
            int reverseidx = cache.getOrDefault(reverse(word), -1);
            if (reverseidx != -1 && reverseidx < i) {
                result.add(List.of(reverseidx, i));
                result.add(List.of(i, reverseidx));
            }
            // Find shorter ones around me
            for (int sublen : lengths.headSet(word.length())) {
                if (isPalindrome(word, sublen, word.length() - 1)) {
                    int suffixidx = cache.getOrDefault(reverse(word.substring(0, sublen)), -1);
                    if (suffixidx != -1) {
                        result.add(List.of(i, suffixidx));
                    }
                }
                if (isPalindrome(word, 0, word.length() - sublen - 1)) {
                    int prefixidx = cache.getOrDefault(reverse(word.substring(word.length() - sublen)), -1);
                    if (prefixidx != -1) {
                        result.add(List.of(prefixidx, i));
                    }
                }
            }
        }

        return result;
    }

    String reverse(String input) {
        StringBuilder builder = new StringBuilder();
        for (int j = input.length() - 1; j >= 0; j--)
            builder.append(input.charAt(j));
        return builder.toString();
    }

    boolean isPalindrome(String input, int i, int j) {
        while (i < j) {
            if (input.charAt(i) != input.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"}));
        System.out.println(new Solution().palindromePairs(new String[]{"bat", "tab", "cat"}));
        System.out.println(new Solution().palindromePairs(new String[]{"a", ""}));
        System.out.println(new Solution().palindromePairs(new String[]{"a", "abc", "aba", ""}));
        System.out.println(new Solution().palindromePairs(new String[]{"a", "b", "c", "ab", "ac", "aa"}));
    }
}

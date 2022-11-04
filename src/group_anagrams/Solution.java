package group_anagrams;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> group = new HashMap<>();
        for (String str : strs) {
            String digest = digest(str);
            group.computeIfAbsent(digest, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(group.values());
    }

    String digest(String input) {
        int[] counter = new int[26];
        Arrays.fill(counter, 0);
        for (char c : input.toCharArray()) {
            counter[c - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        for (int c : counter) {
            builder.append(c).append(',');
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}

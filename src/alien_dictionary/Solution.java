package alien_dictionary;

import java.util.*;

public class Solution {

    void desc(Set<Integer> buffer, ArrayList<Integer>[] children, int root) {
        buffer.add(root);
        for (int c : children[root]) {
            desc(buffer, children, c);
        }
    }

    public String alienOrder(String[] words) {
        ArrayList<Integer>[] children = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            children[i] = new ArrayList<>();
        }
        boolean[] nonroot = new boolean[26];
        boolean[] appear = new boolean[26];

        if (words.length == 1) {
            for (char c : words[0].toCharArray()) {
                appear[c - 'a'] = true;
            }
        } else {
            for (int i = 0; i < words.length - 1; i++) {
                String word1 = words[i];
                String word2 = words[i + 1];
                for (int k = 0; k < word1.length(); k++) {
                    int c = word1.charAt(k) - 'a';
                    appear[c] = true;
                }
                for (int k = 0; k < word2.length(); k++) {
                    int c = word2.charAt(k) - 'a';
                    appear[c] = true;
                }
                if (word1.compareTo(word2) == 0) {
                    continue;
                }
                int limit = Math.min(word1.length(), word2.length());
                String longstr = limit == word1.length() ? word2 : word1;
                String shortstr = longstr == word1 ? word2 : word1;
                if (longstr.startsWith(shortstr) && longstr == word1) {
                    return "";
                }
                for (int k = 0; k < limit; k++) {
                    int c1 = word1.charAt(k) - 'a';
                    int c2 = word2.charAt(k) - 'a';

                    if (c1 != c2) {
                        nonroot[c2] = true;
                        // if c2 is already a descdent of c1 then skip
                        // else remove all direct children of c1 that are reachable from c2
                        Set<Integer> c1desc = new HashSet<>();
                        desc(c1desc, children, c1);
                        Set<Integer> c2desc = new HashSet<>();
                        desc(c2desc, children, c2);
                        if (c2desc.contains(c1)) {
                            return "";
                        }
                        if (!c1desc.contains(c2)) {
                            children[c1].removeAll(c2desc);
                            children[c1].add(c2);
                        }
                        break;
                    }
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        LinkedList<Integer> bfs = new LinkedList<>();
        boolean[] visited = new boolean[26];
        for (
                int i = 0;
                i < 26; i++) {
            if (appear[i] && !nonroot[i]) {
                bfs.add(i);
                visited[i] = true;
                builder.append((char) ('a' + i));
            }
        }
        while (!bfs.isEmpty()) {
            int size = bfs.size();
            for (int i = 0; i < size; i++) {
                int root = bfs.pop();
                List<Integer> next = children[root];
                for (int n : next) {
                    if (!visited[n]) {
                        visited[n] = true;
                        bfs.push(n);
                        builder.append((char) ('a' + n));
                    }
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().alienOrder(new String[]{"ac", "ab", "zc", "zb"}));
        System.out.println(new Solution().alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
        System.out.println(new Solution().alienOrder(new String[]{"ab", "adc"}));
        System.out.println(new Solution().alienOrder(new String[]{"ab", "abc"}));
        System.out.println(new Solution().alienOrder(new String[]{"abc", "ab"}));
        System.out.println(new Solution().alienOrder(new String[]{"z", "z"}));
        System.out.println(new Solution().alienOrder(new String[]{"wrt", "wrtkj"}));
        System.out.println(new Solution().alienOrder(new String[]{"vlxpwiqbsg", "cpwqwqcd"}));
        System.out.println(new Solution().alienOrder(new String[]{"ri", "xz", "qxf", "jhsguaw", "dztqrbwbm", "dhdqfb", "jdv", "fcgfsilnb", "ooby"}));
    }
}

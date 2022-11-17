package word_break;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    static class TrieNode {
        boolean leaf = false;
        TrieNode[] next = new TrieNode[26];
    }

    static class Trie {
        boolean[] used = new boolean[26];
        TrieNode[] roots = new TrieNode[26];

        void add(String word) {
            TrieNode[] currentMap = roots;
            TrieNode current = null;
            for (char wc : word.toCharArray()) {
                used[wc - 'a'] = true;
                current = currentMap[wc - 'a'];
                if (current == null) {
                    current = new TrieNode();
                    currentMap[wc - 'a'] = current;
                }
                currentMap = current.next;
            }
            current.leaf = true;
        }

        boolean validate(String s) {
            for (char c : s.toCharArray()) {
                if (!used[c - 'a']) {
                    return false;
                }
            }
            return true;
        }
    }

    Trie buildTrie(List<String> words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.add(word);
        }
        return trie;
    }

    boolean dfs(Trie trie, String s, int pointer) {
        if (pointer == s.length()) {
            return true;
        }
        if (blocked[pointer]) {
            return false;
        }
        TrieNode[] maps = trie.roots;
        while (pointer < s.length()) {
            TrieNode next = maps[s.charAt(pointer) - 'a'];
            if (next == null) {
                blocked[pointer] = true;
                return false;
            } else {
                if (next.leaf && dfs(trie, s, pointer + 1)) {
                    return true;
                }
                maps = next.next;
            }
            pointer++;
        }
        return false;
    }

    boolean[] blocked;

    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = buildTrie(wordDict);
        if (!trie.validate(s)) {
            return false;
        }
        blocked = new boolean[s.length()];
        return dfs(trie, s, 0);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                List.of("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));
    }
}

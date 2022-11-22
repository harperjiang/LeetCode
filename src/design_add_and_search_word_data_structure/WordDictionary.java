package design_add_and_search_word_data_structure;

public class WordDictionary {

    static class TrieNode {
        TrieNode[] content = new TrieNode[26];
        boolean leaf;
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.content[index] == null) current.content[index] = new TrieNode();
            current = current.content[index];
        }
        current.leaf = true;
    }

    boolean dfs(String word, int index, TrieNode current) {
        if (null == current) {
            return false;
        }
        if (index == word.length()) {
            return current != null && current.leaf;
        }
        if (word.charAt(index) == '.') {
            for (TrieNode next : current.content) {
                if (next != null && dfs(word, index + 1, next)) {
                    return true;
                }
            }
            return false;
        } else {
            int i = word.charAt(index) - 'a';
            TrieNode next = current.content[i];
            return dfs(word, index + 1, next);
        }
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }
}
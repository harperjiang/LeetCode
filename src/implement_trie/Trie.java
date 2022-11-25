package implement_trie;

public class Trie {

    static class TrieNode {
        TrieNode[] content = new TrieNode[26];
        boolean leaf;
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.content[index] == null) {
                current.content[index] = new TrieNode();
            }
            current = current.content[index];
        }
        current.leaf = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (current == null) {
                return false;
            }
            int index = c - 'a';
            current = current.content[index];
        }
        return current != null && current.leaf;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            if (current == null) {
                return false;
            }
            int index = c - 'a';
            current = current.content[index];
        }
        return current != null;
    }
}

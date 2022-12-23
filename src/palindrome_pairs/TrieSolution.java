package palindrome_pairs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TrieSolution {

    class TrieNode {
        Set<Integer> index = new HashSet<>();

        int depth;
        int leaf = -1;
        TrieNode[] next = new TrieNode[26];
    }

    String[] words;

    TrieNode build() {
        this.headcache = new Boolean[words.length][];
        this.tailcache = new Boolean[words.length][];
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            headcache[i] = new Boolean[word.length()];
            tailcache[i] = new Boolean[word.length()];
            TrieNode current = root;
            for (int j = 0; j < word.length(); j++) {
                char c = word.charAt(j);
                int cindex = c - 'a';
                if (current.next[cindex] == null) {
                    TrieNode newnode = new TrieNode();
                    newnode.index.add(i);
                    newnode.depth = j;
                    current.next[cindex] = newnode;
                } else {
                    current.next[cindex].index.add(i);
                }
                current = current.next[cindex];
            }
            current.leaf = i;
        }
        return root;
    }

    Boolean[][] headcache;
    Boolean[][] tailcache;

    boolean isPalindromeHead(int i, int j) {
        if (headcache[i][j] == null) {
            String word = words[i];
            int start = 0, stop = j;
            while (start < stop && word.charAt(start) == word.charAt(stop)) {
                start++;
                stop--;
            }
            headcache[i][j] = start >= stop;
        }
        return headcache[i][j];
    }

    boolean isPalindromeTail(int i, int j) {
        if (tailcache[i][j] == null) {
            String word = words[i];
            int start = j + 1, stop = word.length() - 1;
            while (start < stop && word.charAt(start) == word.charAt(stop)) {
                start++;
                stop--;
            }
            tailcache[i][j] = start >= stop;
        }
        return tailcache[i][j];
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        this.words = words;
        TrieNode root = build();

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.isEmpty()) {
                for (int j = 0; j < words.length; j++) {
                    if (j != i && isPalindromeHead(j, words[j].length() - 1)) {
                        result.add(List.of(j, i));
                    }
                }
                continue;
            }
            TrieNode current = root;
            for (int j = word.length() - 1; j >= 0; j--) {
                if (current.leaf != -1 && isPalindromeHead(i, j)) {
                    if (current.leaf != i)
                        result.add(List.of(current.leaf, i));
                }
                // Scan the incoming word from back
                char c = word.charAt(j);
                int cindex = c - 'a';
                current = current.next[cindex];
                if (current == null) {
                    break;
                }
            }
            if (current != null) { // Incoming word is shorter than the trie
                for (int w : current.index) {
                    if (w != i && isPalindromeTail(w, current.depth)) {
                        result.add(List.of(w, i));
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"}));
//        System.out.println(new Solution().palindromePairs(new String[]{"bat","tab","cat"}));
//        System.out.println(new Solution().palindromePairs(new String[]{"a", ""}));
//        System.out.println(new Solution().palindromePairs(new String[]{"a", "abc", "aba", ""}));
//        System.out.println(new Solution().palindromePairs(new String[]{"a", "b", "c", "ab", "ac", "aa"}));
    }
}

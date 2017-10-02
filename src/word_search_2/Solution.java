package word_search_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {

    char[][] board;
    boolean[] matched;
    int width;
    int height;

    public List<String> findWords(char[][] board, String[] words) {
        if (board.length == 0)
            return new ArrayList<String>();
        init(board, words);

        int path[][] = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                reset();
                search(i, j, path);
            }
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (matched[i])
                result.add(words[i]);
        }
        return result;
    }

    protected void search(int i, int j, int[][] path) {
        if (i < 0 || j < 0 || i >= width || j >= height || path[i][j] != 0)
            return;
        // match current
        if (match(board[i][j])) {
            path[i][j] = 1;
            // search next in 4 directions
            search(i, j + 1, path);
            search(i + 1, j, path);
            search(i - 1, j, path);
            search(i, j - 1, path);
            path[i][j] = 0;
            back();
        } else {
            return;
        }
    }

    static class Node {
        int leaf = -1;
        Node parent;
        Node[] next = new Node[26];
    }

    Node root = new Node();
    Node current;

    void init(char[][] board, String[] words) {
        this.board = board;
        this.width = board.length;
        this.height = board[0].length;
        this.matched = new boolean[words.length];

        Node me = root;
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            me = root;
            for (char c : w.toCharArray()) {
                int idx = c - 'a';
                if (me.next[idx] == null) {
                    me.next[idx] = new Node();
                    me.next[idx].parent = me;
                }
                me = me.next[idx];
            }
            me.leaf = i;
        }
        reset();
    }

    void reset() {
        current = root;
    }

    void back() {
        current = current.parent;
    }

    boolean match(char c) {
        Node next = current.next[c - 'a'];
        if (next == null)
            return false;
        if (next.leaf != -1) {
            // End of match
            this.matched[next.leaf] = true;
        }
        current = next;
        return true;
    }
}
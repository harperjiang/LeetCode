package word_search;

public class Solution {

    char[][] board;
    String word;
    int width;
    int height;

    public boolean search(int i, int j, int pointer) {
        if (board[i][j] != word.charAt(pointer)) {
            return false;
        }
        if (pointer == word.length() - 1) {
            return true;
        }
        char b = board[i][j];
        board[i][j] = 0;
        boolean result = (i > 0 && search(i - 1, j, pointer + 1))
                || (i < height - 1 && search(i + 1, j, pointer + 1))
                || (j > 0 && search(i, j - 1, pointer + 1))
                || (j < width - 1 && search(i, j + 1, pointer + 1));
        board[i][j] = b;
        return result;
    }

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        width = board[0].length;
        height = board.length;
        for (int i = 0; i < height; ++i) {
            char[] row = board[i];
            for (int j = 0; j < width; ++j) {
                if (search(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().exist(new char[][]{
                new char[]{'A','B','C','E'},
                new char[]{'S','F','C','S'},
                new char[]{'A','D','E','E'}
        },"ABCCED"));

        System.out.println(new Solution().exist(new char[][]{
                new char[]{'A','B','C','E'},
                new char[]{'S','F','C','S'},
                new char[]{'A','D','E','E'}
        },"ABCB"));
    }
}

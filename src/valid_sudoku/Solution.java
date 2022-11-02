package valid_sudoku;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][];
        int[][] cols = new int[9][];
        for (int i = 0; i < 9; ++i) {
            rows[i] = new int[3];
            cols[i] = new int[3];
            for (int j = 0; j < 3; ++j) {
                int a = fetch(board, i, j * 3);
                int b = fetch(board, i, j * 3 + 1);
                int c = fetch(board, i, j * 3 + 2);
                if ((a == b && a != 0) || (b == c && b != 0) || (a == c && a != 0)) {
                    return false;
                }
                rows[i][j] = a + b + c;
                a = fetch(board, j * 3, i);
                b = fetch(board, j * 3 + 1, i);
                c = fetch(board, j * 3 + 2, i);
                if ((a == b && a != 0) || (b == c && b != 0) || (a == c && a != 0)) {
                    return false;
                }
                cols[i][j] = a + b + c;
            }
            if (overlap(rows[i][0], rows[i][1], rows[i][2])) {
                return false;
            }
            if (overlap(cols[i][0], cols[i][1], cols[i][2])) {
                return false;
            }
        }
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (overlap(rows[3 * i][j], rows[3 * i + 1][j], rows[3 * i + 2][j])) {
                    return false;
                }
            }
        }

        return true;
    }

    protected int fetch(char[][] board, int i, int j) {
        if (board[i][j] == '.') {
            return 0;
        }
        return 1 << (board[i][j] - '0');
    }

    public boolean overlap(int bm1, int bm2, int bm3) {
        if (bm1 == bm2 && bm2 == bm3 && bm1 != 0) {
            return true;
        }
        int mask = bm1 ^ bm2 ^ bm3;
        return !((mask & bm1) == bm1 &&
                (mask & bm2) == bm2 &&
                (mask & bm3) == bm3);
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().isValidSudoku(
//                new char[][]{new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//                        new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                        new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                        new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                        new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                        new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                        new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                        new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                        new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'}}));
//        System.out.println(new Solution().isValidSudoku(
//                new char[][]{
//                        new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
//                        new char[]{'.', '.', '.', '3', '.', '.', '5', '.', '.'},
//                        new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
//                        new char[]{'.', '.', '.', '8', '.', '.', '.', '.', '.'},
//                        new char[]{'.', '.', '.', '.', '1', '1', '6', '.', '.'},
//                        new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
//                        new char[]{'.', '.', '.', '.', '.', '.', '1', '.', '.'},
//                        new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '7'},
//                        new char[]{'.', '.', '.', '.', '.', '.', '.', '4', '.'}}
//        ));
        System.out.println(new Solution().isValidSudoku(
                new char[][]{
                        new char[]{'.', '.', '.', '1', '.', '8', '.', '.', '.'},
                        new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        new char[]{'4', '.', '.', '.', '.', '7', '.', '.', '.'},
                        new char[]{'.', '.', '.', '7', '.', '.', '8', '4', '1'},
                        new char[]{'.', '.', '.', '.', '7', '.', '.', '.', '.'},
                        new char[]{'.', '.', '.', '.', '.', '.', '6', '.', '.'},
                        new char[]{'.', '.', '.', '6', '.', '.', '.', '.', '.'},
                        new char[]{'6', '.', '.', '.', '.', '.', '.', '.', '.'}}

        ));
    }
}

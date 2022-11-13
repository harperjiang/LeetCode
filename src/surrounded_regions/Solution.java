package surrounded_regions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    int[][] searchdir = new int[][]{new int[]{0, 1}, new int[]{0, -1}, new int[]{-1, 0}, new int[]{1, 0}};

    void bfs(char[][] board, int height, int width, int i, int j) {
        LinkedList<Integer> buffer = new LinkedList<>();
        buffer.add((i << 16) + j);
        board[i][j]='T';
        while (!buffer.isEmpty()) {
            int size = buffer.size();
            for (int idx = 0; idx < size; ++idx) {
                int next = buffer.pop();
                int ni = next >> 16;
                int nj = next & 0xFFFF;
                // for non-visited
                for (int[] sd : searchdir) {
                    int nni = ni + sd[0];
                    int nnj = nj + sd[1];
                    if (nni >= 0 && nni < height && nnj >= 0 && nnj < width && board[nni][nnj] == 'O') {
                        board[nni][nnj] = 'T';
                        buffer.add((nni << 16) + nnj);
                    }
                }
            }
        }
    }

    public void solve(char[][] board) {
        int width = board[0].length;
        int height = board.length;
        for (int i = 0; i < height; ++i) {
            if (board[i][0] == 'O') {
                bfs(board, height, width, i, 0);
            }
            if (board[i][width-1] == 'O') {
                bfs(board, height, width, i, width-1);
            }
        }
        for (int j = 0; j < width; ++j) {
            if (board[0][j] == 'O') {
                bfs(board, height, width, 0, j);
            }
            if(board[height-1][j] == 'O') {
                bfs(board, height, width, height-1, j);
            }
        }
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {
        new Solution().solve(new char[][]{
                new char[]{'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O'},
                new char[]{'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                new char[]{'X', 'O', 'O', 'X', 'O', 'X', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O'},
                new char[]{'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'O'},
                new char[]{'O', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                new char[]{'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'O'},
                new char[]{'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                new char[]{'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O'},
                new char[]{'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O'},
                new char[]{'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                new char[]{'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                new char[]{'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                new char[]{'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                new char[]{'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                new char[]{'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                new char[]{'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'X'},
                new char[]{'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'O'},
                new char[]{'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                new char[]{'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'O', 'O', 'X'},
                new char[]{'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O'}
        });
    }
}

package game_of_life;

public class Solution {
    public void gameOfLife(int[][] board) {

        int[][] poss = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int[] pos : poss) {
                    int nx = i + pos[0];
                    int ny = j + pos[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                        sum += board[nx][ny] & 0xFFFF;
                    }
                }
                if (sum < 2 || sum > 3) {
                    board[i][j] &= 0xFFFF;
                } else if (sum == 3) {
                    board[i][j] |= 0x10000;
                } else {
                    board[i][j] += (board[i][j] << 16);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 16;
            }
        }
    }

    public static void main(String[] args) {
        new Solution().gameOfLife(new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}});
    }
}

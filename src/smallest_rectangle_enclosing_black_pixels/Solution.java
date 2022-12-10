package smallest_rectangle_enclosing_black_pixels;

import java.util.LinkedList;

public class Solution {

    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    void dfs(char[][] board, int x, int y) {
        int m = board.length;
        int n = board[0].length;
        LinkedList<int[]> buffer = new LinkedList<>();
        buffer.add(new int[]{x, y});
        board[x][y] = '2';

        while (!buffer.isEmpty()) {
            int size = buffer.size();
            for (int i = 0; i < size; i++) {
                int[] next = buffer.pop();
                lx = Math.min(lx, next[0]);
                ly = Math.min(ly, next[1]);
                ux = Math.max(ux, next[0]);
                uy = Math.max(uy, next[1]);
                for (int[] dir : dirs) {
                    int nx = dir[0] + next[0];
                    int ny = dir[1] + next[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == '1') {
                        board[nx][ny] = '2';
                        buffer.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    int lx;
    int ux;
    int ly;
    int uy;

    public int minArea(char[][] image, int x, int y) {
        int m = image.length;
        int n = image[0].length;
        lx = m;
        ly = n;
        ux = -1;
        uy = -1;
        dfs(image, x, y);
        return (ux + 1 - lx) * (uy + 1 - ly);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minArea(new char[][]{{'0', '0', '1', '0'}, {'0', '1', '1', '0'}, {'0', '1', '0', '0'}}, 0, 2));
    }
}

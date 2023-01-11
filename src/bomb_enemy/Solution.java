package bomb_enemy;

public class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] cache = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            int j = 0, j2 = 0;
            while (j < n) {
                while (j < n && grid[i][j] == 'W') j++;
                j2 = j;
                int ec = 0;
                while (j2 < n && grid[i][j2] != 'W') {
                    if (grid[i][j2] == 'E') ec++;
                    j2++;
                }
                for (int k = j; k < j2; k++) {
                    cache[i][k] = ec;
                }
                j = j2;
            }
        }
        for (int i = 0; i < n; i++) {
            int j = 0, j2 = 0;
            while (j < m) {
                while (j < m && grid[j][i] == 'W') j++;
                j2 = j;
                int ec = 0;
                while (j2 < m && grid[j2][i] != 'W') {
                    if (grid[j2][i] == 'E') ec++;
                    j2++;
                }
                for (int k = j; k < j2; k++) {
                    if (grid[k][i] == '0') {
                        max = Math.max(ec + cache[k][i], max);
                    }
                }
                j = j2;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxKilledEnemies(new char[][]{
                {'0', 'E', '0', '0'}, {'E', '0', 'W', 'E'}, {'0', 'E', '0', '0'}
        }));
        System.out.println(new Solution().maxKilledEnemies(new char[][]{
                {'W', 'W', 'W'}, {'0', '0', '0'}, {'E', 'E', 'E'}
        }));
    }
}

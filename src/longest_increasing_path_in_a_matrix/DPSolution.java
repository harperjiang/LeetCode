package longest_increasing_path_in_a_matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DPSolution {
    int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] degree = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] dir : dirs) {
                    int nx = i + dir[0];
                    int ny = j + dir[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && matrix[nx][ny] > matrix[i][j]) {
                        degree[i][j]++;
                    }
                }
            }
        }
        LinkedList<int[]> leaves = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (degree[i][j] == 0) {
                    leaves.add(new int[]{i, j});
                }
            }
        }
        int height = 0;
        while (!leaves.isEmpty()) {
            int size = leaves.size();

            for (int i = 0; i < size; i++) {
                int[] next = leaves.pop();
                for (int[] dir : dirs) {
                    int nx = next[0] + dir[0];
                    int ny = next[1] + dir[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && degree[nx][ny] > 0 && matrix[nx][ny] < matrix[next[0]][next[1]]) {
                        degree[nx][ny]--;
                        if (degree[nx][ny] == 0) {
                            leaves.add(new int[]{nx, ny});
                        }
                    }
                }
            }
            height++;
        }
        return height;
    }
}

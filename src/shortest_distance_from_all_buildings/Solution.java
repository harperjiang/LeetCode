package shortest_distance_from_all_buildings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dists = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) { // A building
                    // Do a BFS search
                    if (dists[i][j] == -1) {
                        return -1; // One building cannot reach another building
                    }
                    boolean[][] visited = new boolean[m][n];
                    int[][] dist = new int[m][n];
                    LinkedList<int[]> buffer = new LinkedList<>();
                    buffer.add(new int[]{i, j});
                    visited[i][j] = true;
                    int counter = 0;
                    while (!buffer.isEmpty()) {
                        int size = buffer.size();
                        for (int k = 0; k < size; k++) {
                            int[] next = buffer.pop();
                            for (int[] dir : dirs) {
                                int nx = next[0] + dir[0];
                                int ny = next[1] + dir[1];
                                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                                    visited[nx][ny] = true;
                                    if (grid[nx][ny] > 0) {
                                        dist[nx][ny] = counter + 1;
                                    } else {
                                        buffer.add(new int[]{nx, ny});
                                    }
                                }
                            }
                            dist[next[0]][next[1]] = counter;
                        }
                        counter++;
                    }

                    for (int x = 0; x < m; x++) {
                        for (int y = 0; y < n; y++) {
                            if (visited[x][y]) {
                                dists[x][y] += dist[x][y];
                            } else {
                                dists[x][y] = Integer.MIN_VALUE;
                            }
                        }
                    }

                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                boolean empty = grid[x][y] == 0;
                if (empty && dists[x][y] >= 0)
                    min = Math.min(min, dists[x][y]);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().shortestDistance(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
        System.out.println(new Solution().shortestDistance(new int[][]{{1, 0}}));
        System.out.println(new Solution().shortestDistance(new int[][]{{0, 2, 1}, {1, 0, 2}, {0, 1, 0}}));
        System.out.println(new Solution().shortestDistance(new int[][]{{1, 1}, {0, 1}}));
    }
}

package range_sum_query_2d;

import java.util.Arrays;

public class NumMatrix {

    int[][] matrix;
    int[][] buffer;

    int[][] cumsum;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        int n = matrix[0].length;
        buffer = new int[matrix.length][];
        cumsum = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            buffer[i] = new int[n];
            Arrays.fill(buffer[i], Integer.MIN_VALUE);
            cumsum[i] = new int[n];
            cumsum[i][0] = matrix[i][0];
            for (int j = 1; j < n; j++) {
                cumsum[i][j] = cumsum[i][j - 1] + matrix[i][j];
            }
        }
        buffer[0][0] = matrix[0][0];
    }

    private int region(int x, int y) {
        if (x < 0 || y < 0) {
            return 0;
        }
        if (buffer[x][y] != Integer.MIN_VALUE) {
            return buffer[x][y];
        }
        buffer[x][y] = x == 0 ? cumsum[0][y] : region(x - 1, y) + cumsum[x][y];
        return buffer[x][y];
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return region(row2, col2) - region(row2, col1 - 1) - region(row1 - 1, col2) + region(row1-1, col1-1);
    }

    public static void main(String[] args) {
        NumMatrix nm = new NumMatrix(new int[][]{
                {3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}
        });
        System.out.println(nm.sumRegion(2, 1, 4, 3));
        System.out.println(nm.sumRegion(2, 1, 4, 3));
    }
}

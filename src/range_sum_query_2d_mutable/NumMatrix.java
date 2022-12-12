package range_sum_query_2d_mutable;

public class NumMatrix {

    int[][] matrix;
    int m, n;
    int[][] tree;

    /**
     * Idea: create m * n Fenwick trees
     *
     * @param matrix
     */
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;

        tree = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = 0;
                update(i, j, temp);
            }
        }
    }

    public void update(int row, int col, int val) {
        // Update the Fenwick Tree corresponding to the row
        int diff = val - matrix[row][col];
        for (int i = row + 1; i < m + 1; i += i & (-i)) {
            for (int j = col + 1; j < n + 1; j += j & (-j)) {
                tree[i][j] += diff;
            }
        }
        matrix[row][col] += diff;
    }

    int cumsum(int row, int col) {
        if (row < 0 || col < 0) {
            return 0;
        }
        int sum = 0;
        for (int i = row + 1; i > 0; i -= i & (-i)) {
            for (int j = col + 1; j > 0; j -= j & (-j)) {
                sum += tree[i][j];
            }
        }
        return sum;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return cumsum(row2, col2) - cumsum(row2, col1 - 1) - cumsum(row1 - 1, col2) + cumsum(row1 - 1, col1 - 1);
    }

    public static void main(String[] args) {
        NumMatrix nm = new NumMatrix(new int[][]{{1, 2, 3, 4}, {2, 3, 4, 6}, {3, 1, 2, 6}, {4, 4, 2, 7}});
        System.out.println(nm.sumRegion(0, 0, 3, 3));
    }
}

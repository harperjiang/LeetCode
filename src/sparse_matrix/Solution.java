package sparse_matrix;

public class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        // Check all zero rows in mat1 and all zero cols in mat2
        int m = mat1.length;
        int n = mat1[0].length;
        int k = mat2[0].length;

        long[][] rowBitmap = new long[m][2];
        long[][] colBitmap = new long[k][2];

        for (int i = 0; i < m; i++) {
            long res = 0;
            int round1 = Math.min(n, 64);
            for (int j = 0; j < round1; j++) {
                if (mat1[i][j] != 0) {
                    res |= 1 << j;
                }
            }
            rowBitmap[i][0] = res;
            res = 0;
            for (int j = 64; j < n; j++) {
                if (mat1[i][j] != 0) {
                    res |= 1 << (j - 64);
                }
            }
            rowBitmap[i][1] = res;
        }
        for (int i = 0; i < k; i++) {
            long res = 0;
            int round1 = Math.min(n, 64);
            for (int j = 0; j < round1; j++) {
                if (mat2[j][i] != 0) {
                    res |= 1 << j;
                }
            }
            colBitmap[i][0] = res;
            res = 0;
            for (int j = 64; j < n; j++) {
                if (mat2[j][i] != 0) {
                    res |= 1 << (j - 64);
                }
            }
            colBitmap[i][1] = res;
        }

        int[][] result = new int[m][k];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < k; j++) {
                long[] rb = rowBitmap[i];
                long[] cb = colBitmap[j];
                if ((rb[0] & cb[0]) != 0 || (rb[1] & cb[1]) != 0) {
                    for (int w = 0; w < n; w++) {
                        result[i][j] += mat1[i][w] * mat2[w][j];
                    }
                }
            }
        }
        return result;
    }
}

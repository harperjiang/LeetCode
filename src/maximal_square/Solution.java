package maximal_square;

public class Solution {

    public int maximalSquare(char[][] matrix) {
        int width = matrix[0].length;
        int height = matrix.length;
        int max = 0;
        int[] buffer1 = new int[width + 1];
        int[] buffer2 = new int[width + 1];

        int[] b = buffer1;
        int[] nb = buffer2;
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                if (matrix[i][j] == '1') {
                    nb[j + 1] = Math.min(Math.min(b[j], b[j + 1]), nb[j]) + 1;
                    max = Math.max(nb[j + 1]*nb[j+1], max);
                } else {
                    nb[j+1] = 0;
                }
            }
            int[] temp = b;
            b = nb;
            nb = temp;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximalSquare(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        }));
    }
}

package spiral_matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        int loop = Math.min(width, height) / 2;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < loop; ++i) {
            for (int j = i; j < width - i; j++) {
                result.add(matrix[i][j]);
            }
            for (int j = i + 1; j < height - i; j++) {
                result.add(matrix[j][width - 1 - i]);
            }
            for (int j = width - i - 2; j >= i; j--) {
                result.add(matrix[height - i - 1][j]);
            }
            for (int j = height - i - 2; j >= i + 1; j--) {
                result.add(matrix[j][i]);
            }
        }
        if (height > width && width % 2 == 1) {
            for (int i = loop; i < height - loop; ++i) {
                result.add(matrix[i][width / 2]);
            }
        } else if (width > height && height % 2 == 1) {
            for (int i = loop; i < width - loop; ++i) {
                result.add(matrix[height / 2][i]);
            }
        } else if (width == height && height % 2 == 1) {
            result.add(matrix[width / 2][width / 2]);
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().spiralOrder(new int[][]{
//                new int[]{1, 2, 3, 4}, new int[]{8, 7, 6, 5}
//        }));
        System.out.println(new Solution().spiralOrder(new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{10, 11, 12, 5},
                new int[]{9, 8, 7, 6}
        }));
        System.out.println(new Solution().spiralOrder(new int[][]{
                new int[]{1, 2, 3,},
                new int[]{8, 9, 4},
                new int[]{7, 6, 5}
        }));
    }

}

package search_a_2d_matrix;

public class Solution {

    int pick(int[][] matrix, int width, int pos) {
        return matrix[pos / width][pos % width];
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int height = matrix.length;
        int width = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[height - 1][width - 1]) {
            return false;
        }
        int size = width * height;
        int left = 0, right = size;
        while (left <= right) {
            if (left == right) {
                return pick(matrix, width, left) == target ? true : false;
            }
            int middle = (left + right) / 2;
            int midval = pick(matrix, width, middle);
            if (midval == target) {
                return true;
            } else if (midval > target) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().searchMatrix(new int[][]{
                new int[]{1, 3, 5, 7},
                new int[]{10, 11, 16, 20},
                new int[]{23, 30, 34, 60}
        }, 3));
        System.out.println(new Solution().searchMatrix(new int[][]{
                new int[]{1, 3, 5, 7},
                new int[]{10, 11, 16, 20},
                new int[]{23, 30, 34, 60}
        }, 13));
    }
}

package set_matrix_zeros;

public class Solution {

	private boolean exist(int[][] matrix, int num) {
		int m = matrix.length;
		int n = matrix[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (num == matrix[i][j])
					return true;
			}
		}
		return false;
	}

	public void setZeroes(int[][] matrix) {
		if (matrix == null || matrix.length < 1) {
			return;
		}

		int m = matrix.length;
		int n = matrix[0].length;

		int mark = 0;
		// Find a number that doesn't exist in the matrix
		int max = 0;
		int min = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				max = Math.max(max, matrix[i][j]);
				min = Math.min(min, matrix[i][j]);
			}
		}

		if (max < Integer.MAX_VALUE) {
			mark = max + 1;
		}
		if (mark == 0 && min > Integer.MIN_VALUE) {
			mark = min - 1;
		}
		if (mark == 0) {// Tricky method, use random number
			java.util.Random rand = new java.util.Random(
					System.currentTimeMillis());
			mark = rand.nextInt(Integer.MAX_VALUE);
			while (mark == 0 || exist(matrix, mark)) {
				mark = rand.nextInt(Integer.MAX_VALUE);
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					for (int ii = 0; ii < m; ii++) {
						if (matrix[ii][j] != 0)
							matrix[ii][j] = mark;
					}
					for (int ij = 0; ij < n; ij++) {
						if (matrix[i][ij] != 0)
							matrix[i][ij] = mark;
					}
				}
			}
		}

		// Replace all marks with 0
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < m; i++) {
				if (matrix[i][j] == mark) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 0, 0, 0, 5 }, { 4, 3, 1, 4 }, { 0, 1, 1, 4 },
				{ 1, 2, 1, 3 }, { 0, 0, 1, 1 } };
		int m = matrix.length;
		int n = matrix[0].length;
		System.out.println("Matrix:");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(String.format("%d\t", matrix[i][j]));
			}
			System.out.println();
		}

		Solution s = new Solution();
		s.setZeroes(matrix);

		System.out.println("Matrix:");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(String.format("%d\t", matrix[i][j]));
			}
			System.out.println();
		}
	}
}

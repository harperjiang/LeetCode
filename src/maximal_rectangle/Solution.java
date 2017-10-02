package maximal_rectangle;

class Solution {
	public int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0) {
			return 0;
		}
		int width = matrix.length;
		int height = matrix[0].length;

		// compute the left-right boundary for each point
		int[][][] lrh = new int[width][height][3];
		int max = 0;

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (matrix[i][j] == '1') {
					lrh[i][j][2] = i == 0 ? 1 : lrh[i - 1][j][2] + 1;
					lrh[i][j][0] = j != 0 ? lrh[i][j - 1][0] : -1;
				} else {
					lrh[i][j][0] = j;
					lrh[i][j][1] = j;
					lrh[i][j][2] = 0;
				}
				if (matrix[i][height - 1 - j] == '1') {
					lrh[i][height - 1 - j][2] = i == 0 ? 1 : lrh[i - 1][height - j - 1][2] + 1;
					lrh[i][height - 1 - j][1] = (j == 0) ? height : lrh[i][height - j][1];
				} else {
					lrh[i][height - 1 - j][0] = height - 1 - j;
					lrh[i][height - 1 - j][1] = height - 1 - j;
					lrh[i][height - 1 - j][2] = 0;
				}
			}

			for (int j = 0; j < height; j++) {
				if (lrh[i][j][2] > 1) {
					lrh[i][j][0] = Integer.max(lrh[i - 1][j][0], lrh[i][j][0]);
					lrh[i][j][1] = Integer.min(lrh[i - 1][j][1], lrh[i][j][1]);
				}
			}

			for (int j = 0; j < height; j++) {
				if (matrix[i][j] == '1') {
					int l = lrh[i][j][0];
					int r = lrh[i][j][1];
					int h = lrh[i][j][2];
					max = Integer.max(max, h * (r - l - 1));
				}
			}
		}

		return max;
	}
}

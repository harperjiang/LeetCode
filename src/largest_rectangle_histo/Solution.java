package largest_rectangle_histo;

class Solution {
	public int largestRectangleArea(int[] heights) {
		if (heights.length == 0)
			return 0;
		if (heights.length == 1)
			return heights[0];

		int leftLess[] = new int[heights.length];
		int rightLess[] = new int[heights.length];
		leftLess[0] = -1;
		// Compute the leftLess and rightLess
		for (int i = 1; i < heights.length; i++) {
			int p = i - 1;
			while (p >= 0 && heights[p] >= heights[i]) {
				p = leftLess[p];
			}
			leftLess[i] = p;
		}
		rightLess[heights.length - 1] = heights.length;
		for (int i = heights.length - 2; i >= 0; i--) {
			int p = i + 1;
			while (p <= heights.length - 1 && heights[p] >= heights[i])
				p = rightLess[p];
			rightLess[i] = p;
		}

		int max = 0;

		for (int i = 0; i < heights.length; i++) {
			max = Integer.max(heights[i] * (rightLess[i] - leftLess[i] - 1), max);
		}

		return max;
	}
}

package minimum_rotated_sorted_array;

public class Solution {
	public int findMin(int[] num) {
		for (int i = 1; i < num.length; i++) {
			if (num[i - 1] > num[i])
				return num[i];
		}
		return num[0];
	}
}
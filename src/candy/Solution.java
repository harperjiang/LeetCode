package candy;

/**
 * Created by harper on 10/2/17.
 */
public class Solution {

	public int candy(int[] ratings) {
		// One pass to look for local max and local min
		if (ratings.length == 0)
			return 0;

		int sum = 1;
		int current = 1;
		int numDesc = 0;

		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] == ratings[i - 1]) {
				if (numDesc != 0) {
					sum += (1 + numDesc) * (numDesc) / 2;
					if (numDesc >= current) {
						sum += numDesc - current + 1;
					}
					numDesc = 0;
				}
				current = 1;
				sum += current;
			} else if (ratings[i] > ratings[i - 1]) {
				if (numDesc != 0) {
					sum += (1 + numDesc) * (numDesc) / 2;
					if (numDesc >= current) {
						sum += numDesc - current + 1;
					}
					numDesc = 0;
					current = 1;
				}
				current++;
				sum += current;
			} else {
				numDesc++;
			}
		}
		if (numDesc > 0) {
			sum += (1 + numDesc) * (numDesc) / 2;
			if (numDesc >= current) {
				sum += numDesc - current + 1;
			}
		}

		return sum;
	}
}

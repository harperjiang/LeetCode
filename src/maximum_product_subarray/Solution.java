package maximum_product_subarray;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	private List<List<Integer>> splitWithZero(int[] A) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> current = new ArrayList<Integer>();
		for (int i : A) {
			if (i == 0) {
				if (!current.isEmpty()) {
					result.add(current);
					current = new ArrayList<Integer>();
				}
			} else {
				current.add(i);
			}
		}
		if (!current.isEmpty())
			result.add(current);
		return result;
	}

	private int maxProd(List<Integer> nozeros) {
		if (nozeros.size() == 1)
			return nozeros.get(0);
		int prod = 1;
		for (int i : nozeros) {
			prod *= i;
		}
		if (prod > 0)
			return prod;
		// Remove either the leading negative or the trailing negative, on which
		// one is bigger.
		int min;
		int leftprod = 1;
		for (min = 0; nozeros.get(min) > 0; min++) {
			leftprod *= nozeros.get(min);
		}
		leftprod *= nozeros.get(min);

		int max;
		int rightprod = 1;
		for (max = nozeros.size() - 1; nozeros.get(max) > 0; max--) {
			rightprod *= nozeros.get(max);
		}
		rightprod *= nozeros.get(max);

		return leftprod > rightprod ? (prod / leftprod) : (prod / rightprod);
	}

	public int maxProduct(int[] A) {
		if (A.length == 1)
			return A[0];

		List<List<Integer>> arrays = splitWithZero(A);
		int size = 0;
		if (arrays.size() == 0)
			return 0;
		int max = Integer.MIN_VALUE;
		for (List<Integer> array : arrays) {
			size += array.size();
			int res = maxProd(array);
			if (res > max)
				max = res;
		}
		if ((size != A.length) && max < 0)
			return 0;
		return max;
	}

	public static void main(String[] args) {
		int[] A = { -2, 0, -1 };
		System.out.println(new Solution().maxProduct(A));
	}
}
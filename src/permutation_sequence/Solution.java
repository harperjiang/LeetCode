package permutation_sequence;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	private int factorial(int num) {
		if (num <= 1)
			return 1;
		return num * factorial(num - 1);
	}

	public String getPermutation(int n, int k) {
		List<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < n; i++)
			numbers.add(i + 1);
		if (k > factorial(n))
			return "";
		StringBuilder sb = new StringBuilder();

		int divisor = factorial(n - 1);
		int pointer = n - 1;
		int remain = k - 1;
		while (remain != 0) {
			int current = remain / divisor;
			remain = remain % divisor;
			divisor /= pointer;
			pointer--;
			sb.append(numbers.remove(current));
		}
		for (int num : numbers)
			sb.append(num);

		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new Solution().getPermutation(9, 362880));
	}
}

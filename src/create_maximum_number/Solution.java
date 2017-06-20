package create_maximum_number;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 
 * @author harper
 *
 */
public class Solution {

	public int[] maxNumber(int[] nums1, int[] nums2, int k) {

		List<Integer> current = new ArrayList<Integer>();
		List<Integer> a = IntStream.of(nums1).boxed().collect(Collectors.toList());
		List<Integer> b = IntStream.of(nums2).boxed().collect(Collectors.toList());

		if (k == nums1.length + nums2.length) {
			current = merge(a, b);
		} else {
			List<List<Integer>> n1ext = extract(nums1);
			List<List<Integer>> n2ext = extract(nums2);

			for (int i = 0; i <= k; i++) {
				if (i <= nums1.length && k - i <= nums2.length) {
					// Load max
					List<Integer> n1max = (i == 0) ? new ArrayList<Integer>()
							: n1ext.get(i - 1).stream().map((Integer x) -> nums1[x]).collect(Collectors.toList());
					List<Integer> n2max = (k - i == 0) ? new ArrayList<Integer>()
							: n2ext.get(k - i - 1).stream().map((Integer x) -> nums2[x]).collect(Collectors.toList());

					List<Integer> result = merge(n1max, n2max);
					if (compare(result, current) > 0) {
						current.clear();
						current.addAll(result);
					}
				}
			}
		}
		int[] res = new int[current.size()];
		for (int i = 0; i < current.size(); i++)
			res[i] = current.get(i);
		return res;
	}

	public List<List<Integer>> extract(int[] num1) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < num1.length; i++) {
			List<Integer> piece = new ArrayList<Integer>();
			if (i == 0) {
				piece.add(argmax(num1, 0, num1.length));
			} else {
				for (int l = 0; l < result.get(i - 1).size(); l++)
					piece.add(result.get(i - 1).get(l));

				int start = 0;
				int pointer = 0;
				int mcand = -1;
				int mpointer = -1;
				List<Integer> max = new ArrayList<Integer>();
				List<Integer> buffer = new ArrayList<Integer>();

				while (start < num1.length && pointer <= piece.size()) {
					int end = pointer == piece.size() ? num1.length : piece.get(pointer);
					int cand = argmax(num1, start, end);
					if (-1 != cand) {
						piece.add(pointer, cand);
						buffer = piece.stream().map((Integer idx) -> num1[idx]).collect(Collectors.toList());
						piece.remove(pointer);

						if (compare(buffer, max) > 0) {
							max.clear();
							max.addAll(buffer);
							mcand = cand;
							mpointer = pointer;
						}
					}
					if (pointer < piece.size()) {
						start = piece.get(pointer) + 1;
					}
					pointer++;
				}
				piece.add(mpointer, mcand);

			}
			result.add(piece);
		}
		return result;
	}

	public int argmax(int[] array, int from, int to) {
		int max = -1;
		int idx = -1;
		for (int i = from; i < to; i++) {
			if (array[i] > max) {
				max = array[i];
				idx = i;
			}
		}
		return idx;
	}

	public int compare(List<Integer> n1, List<Integer> n2) {
		if (n1.size() == n2.size()) {
			for (int i = 0; i < n1.size(); i++) {
				if (n1.get(i) - n2.get(i) != 0) {
					return n1.get(i) - n2.get(i);
				}
			}
			return 0;
		}
		return n1.size() - n2.size();
	}

	public List<Integer> merge(List<Integer> a, List<Integer> b) {
		List<Integer> result = new ArrayList<Integer>();
		int counter = 0;
		while (!(a.isEmpty() && b.isEmpty())) {
			int next = 0;
			if (a.isEmpty()) {
				next = b.remove(0);
			} else if (b.isEmpty()) {
				next = a.remove(0);
			} else {
				if (a.get(0) == b.get(0)) {
					// Choose the next piece that is larger
					int min = Math.min(a.size(), b.size());
					if (min == 1) {
						next = (a.size() == 1) ? b.remove(0) : a.remove(0);
					} else {
						List<Integer> anext = a.subList(1, min);
						List<Integer> bnext = b.subList(1, min);
						next = compare(anext, bnext) >= 0 ? a.remove(0) : b.remove(0);
					}
				} else {
					next = (a.get(0) > b.get(0)) ? a.remove(0) : b.remove(0);
				}
			}
			result.add(next);
		}
		return result;
	}
}
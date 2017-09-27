package median_two_sorted_arrays;

class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		Array n1 = new Array(nums1);
		Array n2 = new Array(nums2);
		int total = nums1.length + nums2.length;
		if (total % 2 == 0) {
			int second = firstXth(n1, n2, total / 2);
			int first = firstXth(n1, n2, total / 2 - 1);
			return (first + second) / 2;
		} else {
			return firstXth(n1, n2, total / 2);
		}
	}

	protected int firstXth(Array n1, Array n2, int x) {
		if (n1.length() == 0) {
			return n2.get(x);
		}
		if (n2.length() == 0) {
			return n1.get(x);
		}

		int n1median = n1.get(n1.length() / 2);
		int t1 = binarySearch(n2, n1median);

		if (n1.length() / 2 + t1 >= x) {
			return firstXth(n1.subarray(0, n1.length() / 2), n2.subarray(0, t1), x);
		} else {
			return firstXth(n1.subarray(n1.length() / 2 + 1, n1.length()), n2.subarray(t1 + 1, n2.length()),
					x - n1.length() / 2 - t1);
		}
	}

	// Return a index that the key can be inserted and keep the array sorted
	protected int binarySearch(Array array, int key) {
		if (key >= array.last()) {
			return array.stop;
		}
		if (key <= array.first()) {
			return array.start;
		}
		if (array.start == array.stop) {
			return key >= array.first() ? array.start + 1 : array.start;
		}
		int middle = (array.start + array.stop) / 2;
		if (key == array.get(middle)) {
			return middle;
		} else if (key < array.get(middle)) {
			return binarySearch(array.subarray(array.start, middle), key);
		} else {
			return binarySearch(array.subarray(middle, array.stop), key);
		}
	}

	public static class Array {

		private int[] data;

		int start;

		int stop;

		public Array(int[] data) {
			this.data = data;
			this.start = 0;
			this.stop = data.length;
		}

		public int get(int index) {
			return data[start + index];
		}

		public int first() {
			return data[start];
		}

		public int last() {
			return data[stop];
		}

		public int length() {
			return stop - start;
		}

		public Array subarray(int start, int stop) {
			Array sub = new Array(this.data);
			sub.start = this.start + start;
			sub.stop = this.start + stop;
			return sub;
		}
	}
}

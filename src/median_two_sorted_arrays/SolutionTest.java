package median_two_sorted_arrays;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		Solution sol = new Solution();

		assertEquals(2, sol.findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3 }), 0.001);
		assertEquals(2.5, sol.findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 }), 0.001);
		assertEquals(5, sol.findMedianSortedArrays(new int[] { 1, 3, 5, 6, 7 }, new int[] { 2, 3, 8, 9 }), 0.001);
		assertEquals(3, sol.findMedianSortedArrays(new int[] { 1, 2, 3, 4, 5 }, new int[] { 1, 2, 3, 4, 5 }), 0.001);

		assertEquals(4.5, sol.findMedianSortedArrays(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 },
				new int[] { 1, 2, 3, 4, 5 }), 0.001);
		assertEquals(3.5, sol.findMedianSortedArrays(new int[] { 1, 2, 3, 4, 6 }, new int[] { 5 }), 0.001);
	}

}

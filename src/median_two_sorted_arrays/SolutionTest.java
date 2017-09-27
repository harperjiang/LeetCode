package median_two_sorted_arrays;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void test() {
		Solution sol = new Solution();

		assertEquals(2, sol.findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3 }), 0.001);
		assertEquals(2.5, sol.findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 }), 0.001);
	}

}

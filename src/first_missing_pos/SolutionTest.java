package first_missing_pos;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSolution() {

		Solution sol = new Solution();

		// assertEquals(3, sol.firstMissingPositive(new int[] { 1, 2, 0 }));
		// assertEquals(2, sol.firstMissingPositive(new int[] { 3, 4, -1, 1 }));
		// assertEquals(1, sol.firstMissingPositive(new int[] { 2 }));
		// assertEquals(2, sol.firstMissingPositive(new int[] { 1 }));
		assertEquals(2, sol.firstMissingPositive(new int[] { 1, 1 }));
	}
}

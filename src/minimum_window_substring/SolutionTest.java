package minimum_window_substring;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSolution() {
		Solution sol = new Solution();
		assertEquals("A", sol.minWindow("A", "A"));
		assertEquals("BANC", sol.minWindow("ADOBECODEBANC", "ABC"));
	}
}

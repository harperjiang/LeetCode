package wildcard_matching;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSolution() {
		Solution sol = new Solution();

		assertTrue(sol.isMatch("", "*"));
		assertFalse(sol.isMatch("", "?"));
		assertTrue(sol.isMatch("c", "*?*"));
		assertFalse(sol.isMatch("aa", "a"));
		assertTrue(sol.isMatch("aa", "aa"));
		assertFalse(sol.isMatch("aaa", "aa"));
		assertTrue(sol.isMatch("aa", "*"));
		assertTrue(sol.isMatch("aa", "a*"));
		assertTrue(sol.isMatch("ab", "?*"));
		assertFalse(sol.isMatch("aab", "c*a*b"));

	}
}

package regular_exp_matching;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testIsMatch() {
		Solution sol = new Solution();
//		assertFalse(sol.isMatch("aa", "a"));
//		assertTrue(sol.isMatch("aa", "aa"));
//		assertFalse(sol.isMatch("aaa", "aa"));
//		assertTrue(sol.isMatch("aa", "a*"));
//		assertTrue(sol.isMatch("aa", ".*"));
//		assertTrue(sol.isMatch("ab", ".*"));
//		assertTrue(sol.isMatch("aab", "c*a*b"));
//		assertFalse(sol.isMatch("abcd", "d*"));
//		assertFalse(sol.isMatch("aaa", "ab*a"));
//		assertTrue(sol.isMatch("aabbccd", "a*b*c*d"));
//		assertTrue(sol.isMatch("a", "ab*"));
//		assertTrue(sol.isMatch("bbbba", ".*a*a"));
		assertTrue(sol.isMatch("", ".*"));
	}

}

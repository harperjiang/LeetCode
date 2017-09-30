package longest_valid_parenthesis;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

	@Test
	public void testSolution() {
		Solution sol = new Solution();

		assertEquals(2, sol.longestValidParentheses("()"));
		assertEquals(2, sol.longestValidParentheses("(()"));
		assertEquals(4, sol.longestValidParentheses("(())"));
		assertEquals(4, sol.longestValidParentheses("()()"));
		assertEquals(2, sol.longestValidParentheses("()(()"));
		assertEquals(20, sol.longestValidParentheses("()()()(()((()))())())())(()))))"));
	}
}

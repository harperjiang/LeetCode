package longest_palindromic_substring;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SolutionTest {

    @Test
    public void testSolution() {
        Solution sol = new Solution();

        assertEquals("bab", sol.longestPalindrome("babad"));
    }
}

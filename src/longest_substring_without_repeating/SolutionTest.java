package longest_substring_without_repeating;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution sol = new Solution();

        assertEquals(2, sol.lengthOfLongestSubstring("au"));
        assertEquals(3, sol.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, sol.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, sol.lengthOfLongestSubstring("pwwkew"));
    }
}

package interleaving_string;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by harper on 10/14/17.
 */
public class SolutionTest {
    @Test
    public void testSolution() {
        Solution sol = new Solution();

        assertTrue(sol.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        assertFalse(sol.isInterleave("aabcc", "dbbca", "aadbbbaccc"));

        assertTrue(sol.isInterleave("aa","ab","abaa"));
        assertFalse(sol.isInterleave("bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa",
                "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab",
                "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"));
    }
}

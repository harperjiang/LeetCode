package scramble_string;

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
//        assertTrue(sol.isScramble("great","rgtae"));
//        assertTrue(sol.isScramble("ab","ba"));
        assertFalse(sol.isScramble("abcd","dbac"));
    }
}

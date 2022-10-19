package edit_distance;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by harper on 10/14/17.
 */
public class SolutionTest {
    @Test
    public void testSolution() {
        Solution sol = new Solution();

        assertEquals(1, sol.minDistance("word", "work"));
        assertEquals(4, sol.minDistance("big", "move"));
        assertEquals(1, sol.minDistance("b", ""));
        assertEquals(2, sol.minDistance("ab", "bc"));
    }
}

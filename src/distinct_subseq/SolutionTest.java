package distinct_subseq;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by harper on 10/15/17.
 */
public class SolutionTest {

    @Test
    public void testSolution() {
        Solution sol = new Solution();

//        assertEquals(3, sol.numDistinct("rabbbit", "rabbit"));
        assertEquals(14, sol.numDistinct("abbdacbbcc", "abc"));
    }
}

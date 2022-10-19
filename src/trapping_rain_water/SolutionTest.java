package trapping_rain_water;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by harper on 10/14/17.
 */
public class SolutionTest {
    @Test
    public void testSolution() {
        Solution sol = new Solution();
        assertEquals(6, sol.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        assertEquals(9, sol.trap(new int[]{4, 2, 0, 3, 2, 5}));
        assertEquals(23, sol.trap(new int[]{5, 5, 1, 7, 1, 1, 5, 2, 7, 6}));
        assertEquals(3, sol.trap(new int[]{9, 6, 8, 8, 5, 6, 3}));
    }
}

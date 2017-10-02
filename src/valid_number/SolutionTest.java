package valid_number;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by harper on 10/2/17.
 */
public class SolutionTest {
    @Test
    public void testSolution() {
        Solution sol = new Solution();

        assertTrue(sol.isNumber(" 0.1424"));
        assertTrue(sol.isNumber(" 32e10"));
        assertTrue(sol.isNumber("42497"));
        assertTrue(sol.isNumber("424.23e10"));
        assertTrue(sol.isNumber("-0.1424"));
        assertTrue(sol.isNumber(" -32e10"));
        assertTrue(sol.isNumber("-42497"));
        assertTrue(sol.isNumber("-424.23e10"));
        assertTrue(sol.isNumber(".1"));
        assertTrue(sol.isNumber("3."));
        assertTrue(sol.isNumber("3.e4"));
        assertTrue(sol.isNumber("+.8"));
        assertTrue(sol.isNumber(" 005047e+6"));

        assertFalse(sol.isNumber("323e"));
        assertFalse(sol.isNumber("a21"));
        assertFalse(sol.isNumber("424.."));
        assertFalse(sol.isNumber("."));
        assertFalse(sol.isNumber("-."));
    }
}

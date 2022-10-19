package text_justification;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by harper on 10/14/17.
 */
public class SolutionTest {
    @Test
    public void testSolution() {

        Solution sol = new Solution();

        List<String> formed ;

        formed = sol.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
        assertEquals(3, formed.size());
        assertEquals("This    is    an",formed.get(0));
        assertEquals("example  of text",formed.get(1));
        assertEquals("justification.  ",formed.get(2));

        formed = sol.fullJustify(new String[]{"What","must","be","shall","be."},12);
        assertEquals(2,formed.size());
        assertEquals("What must be",formed.get(0));
        assertEquals("shall be.   ",formed.get(1));
    }
}

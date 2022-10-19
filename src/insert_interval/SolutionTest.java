package insert_interval;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by harper on 10/14/17.
 */
public class SolutionTest {
    @Test
    public void testSolution() {

        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,2));
        intervals.add(new Interval(3,5));
        intervals.add(new Interval(6,7));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(12,16));

        List<Interval> result = new Solution().insert(intervals,new Interval(4,9));

        assertEquals(3, result.size());
    }
}

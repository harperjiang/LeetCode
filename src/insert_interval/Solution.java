package insert_interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by harper on 10/14/17.
 */
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        List<Interval> result = new ArrayList<Interval>();

        int mergeStart = newInterval.start;
        int mergeStop = newInterval.end;

        boolean added = false;
        for (Interval i : intervals) {
            if (overlap(i, newInterval)) {
                mergeStart = Integer.min(mergeStart, i.start);
                mergeStop = Integer.max(mergeStop, i.end);
            } else {
                if (i.start > mergeStop && !added) {
                    result.add(new Interval(mergeStart, mergeStop));
                    added = true;
                }
                result.add(i);
            }
        }
        if(!added) {
            result.add(new Interval(mergeStart,mergeStop));
        }
        return result;
    }


    protected boolean overlap(Interval a, Interval b) {
        if (a.start <= b.start) {
            return a.end >= b.start;
        } else {
            return b.end >= a.start;
        }
    }
}

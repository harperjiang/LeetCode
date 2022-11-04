package merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution2 {

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        List<int[]> buffer = new ArrayList<>();
        for (int[] interval : intervals) {
            buffer.add(interval);
        }
        buffer.sort(Comparator.comparing(i -> i[0]));
        List<int[]> output = new ArrayList<>();
        output.add(buffer.get(0));
        for (int i = 1; i < buffer.size(); i++) {
            int[] back = output.get(output.size() - 1);
            int[] compare = buffer.get(i);
            if (back[1] >= compare[0])
                back[1] = Math.max(back[1], compare[1]);
            else output.add(compare);
        }
        int[][] result = new int[output.size()][];
        output.toArray(result);
        return result;
    }

}

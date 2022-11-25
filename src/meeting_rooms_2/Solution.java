package meeting_rooms_2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int minMeetingRooms(int[][] intervals) {
        List<int[]> sorted = new ArrayList<>();
        for (int[] i : intervals) {
            sorted.add(i);
        }
        sorted.sort(Comparator.comparing(c -> c[0]));
        int[] last = new int[intervals.length];
        int lastPointer = 0;
        for (int[] interval : sorted) {
            int i = 0;
            for (i = 0; i <= lastPointer; ++i) {
                if (last[i] <= interval[0]) {
                    last[i] = interval[1];
                    break;
                }
            }
            if (i == lastPointer + 1) {
                last[++lastPointer] = interval[1];
            }
        }
        return lastPointer + 1;
    }
}

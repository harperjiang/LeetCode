package data_stream_as_disjoint_intervals;

import java.text.MessageFormat;
import java.util.Map;
import java.util.TreeMap;

public class SummaryRanges {

    TreeMap<Integer, Integer> ranges;

    public SummaryRanges() {
        ranges = new TreeMap<>();
    }

    public void addNum(int value) {
        // Check if adjacent with entry before
        Map.Entry<Integer, Integer> entrybefore = ranges.floorEntry(value);
        Integer entryafter = ranges.getOrDefault(value + 1, null);

        if (entrybefore == null || entrybefore.getValue() <= value - 1) {
            //  Nothing to do with entry before, check entry after
            if (entryafter == null) {// after entry does not adjacent
                if (entrybefore != null && entrybefore.getValue() == value - 1) {
                    ranges.put(entrybefore.getKey(), value);
                } else {
                    ranges.put(value, value);
                }
            } else {
                ranges.remove(value + 1);
                if (entrybefore != null && entrybefore.getValue() == value - 1) {
                    // Merge before and after
                    ranges.put(entrybefore.getKey(), entryafter);
                } else {
                    // Only merge value and after
                    ranges.put(value, entryafter);
                }
            }
        }
    }

    public int[][] getIntervals() {
        int[][] result = new int[ranges.size()][2];

        int counter = 0;
        for (Map.Entry<Integer, Integer> entry : ranges.entrySet()) {
            result[counter][0] = entry.getKey();
            result[counter++][1] = entry.getValue();
        }

        return result;
    }


    public static void main(String[] args) {
        SummaryRanges sr = new SummaryRanges();
        sr.addNum(1);
        sr.addNum(0);
//        sr.addNum(3);
//        sr.addNum(7);
//        sr.addNum(2);
//        sr.addNum(6);
        for (int[] val : sr.getIntervals()) {
            System.out.println(MessageFormat.format("{0}:{1}", val[0], val[1]));
        }
    }
}

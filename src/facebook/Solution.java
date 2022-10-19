package facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     given an int array, find out the max length of arithmetic sequence
     examples:
     1, 3, 5, 7
     2,2,2,2
     5, 0, -5

     [1, 2, 3, 5, 20, 9, 7, 0]
     4 -> [1, 3, 5, 7]
     1

     O(N^2) time, O(N^2) memory
     */

    // for each element i: key is the diff, value is the longest invertal ending with i

    public int maxArithSeq(int[] input) {
        List<Map<Integer, Integer>> buffer = new ArrayList<Map<Integer,Integer>>();
        int max = 0;
        for(int i = 0 ; i < input.length;i++) {
            for(int j = i ; j < input.length; j++) {
                while(buffer.size() <=j)
                    buffer.add(new HashMap<Integer,Integer>());
                Map<Integer,Integer> currentIntervals = buffer.get(i);

                int currentInterval = input[j] - input[i];
                int maxLen = 0;
                if(currentIntervals.containsKey(currentInterval)) {
                    maxLen = currentIntervals.get(currentInterval)+1;
                } else {
                    maxLen = 1;
                }
                buffer.get(j).put(currentInterval, maxLen);
                max = Integer.max(max, maxLen);
            }
        }
        return max;
    }
}

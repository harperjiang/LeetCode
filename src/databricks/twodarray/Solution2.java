package databricks.twodarray;

import java.util.*;
import java.util.stream.Collectors;

public class Solution2 {
    public List<Integer> min2d(List<List<Integer>> array) {
        if (array.size() == 1) {
            return List.of(array.get(0).get(0));
        }
        for (List<Integer> row : array) {
            row.sort(Comparator.naturalOrder());
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing((int[] a) -> a[0]));
        for (int i = 0; i < array.size(); i++) {
            List<Integer> row = array.get(i);
            pq.add(new int[]{row.get(0), i, 0});
        }

        int[] maxtuple = Collections.max(pq, Comparator.comparing((int[] a) -> a[0]));
        int min = maxtuple[0] - pq.peek()[0];
        List<Integer> result = pq.stream().map((int[] x) -> x[0]).sorted().collect(Collectors.toList());

        while (true) {
            int[] smallest = pq.poll();
            List<Integer> row = array.get(smallest[1]);
            if (smallest[2] == row.size() - 1) {
                break; // no more
            }
            pq.add(new int[]{row.get(smallest[2] + 1), smallest[1], smallest[2] + 1});

            int[] maxnow = Collections.max(pq, Comparator.comparing((int[] a) -> a[0]));
            int[] minnow = pq.peek();
            if(maxnow[0]-minnow[0]<min) {
                result = pq.stream().map((int[] x) -> x[0]).sorted().collect(Collectors.toList());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().min2d(List.of(
                new ArrayList<Integer>(List.of(90, 61, 60)),
                new ArrayList<Integer>(List.of(61, 59)),
                new ArrayList<Integer>(List.of(62, 58, 92))
        )));
    }

}

package databricks.twodarray;

import java.util.*;

public class Solution {

    public List<Integer> min2d(List<List<Integer>> matrix) {
        if (matrix.size() == 1) {
            return List.of(matrix.get(0).get(0));
        }

        int m = matrix.size();
        List<int[]> scanner = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int val : matrix.get(i))
                scanner.add(new int[]{val, i});
        }
        scanner.sort(Comparator.comparing((int[] i) -> i[0]));

        int from = 0;
        int min = Integer.MAX_VALUE;
        int counter[] = new int[3];
        int total = 0;

        List<Integer> result = null;

        for (int i = 0; i < scanner.size(); i++) {
            int[] scan = scanner.get(i);
            total += (counter[scan[1]] == 0) ? 1 : 0;
            counter[scan[1]]++;
            if (i < scanner.size() - 1 && scanner.get(i + 1)[0] == scan[0]) {
                // Keep scanning all equal values in one step
                continue;
            }

            while (counter[scanner.get(from)[1]] > 1) {
                counter[scanner.get(from)[1]]--;
                from++;
            }
            if (total == m) {
                int diff = scan[0] - scanner.get(from)[0];
                if (diff < min) {
                    min = diff;

                    Map<Integer, Integer> rbylane = new HashMap<>();
                    for (int j = from; j <= i; j++) {
                        rbylane.put(scanner.get(j)[1], scanner.get(j)[0]);
                    }
                    result = new ArrayList<>(rbylane.values());
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().min2d(List.of(
                List.of(90, 61, 60),
                List.of(61, 59),
                List.of(62, 58, 92)
        )));
    }
}

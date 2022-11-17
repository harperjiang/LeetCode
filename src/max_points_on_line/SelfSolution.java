package max_points_on_line;

public class SelfSolution {
    public int maxPoints(int[][] points) {
        if (points.length <= 1) {
            return points.length;
        }
        int max = -1;
        for (int i = 0; i < points.length; ++i) {
            int[] pi = points[i];
            for (int j = i + 1; j < points.length; ++j) {
                int[] pj = points[j];
                int a = pj[0] - pi[0];
                int b = pi[1] - pj[1];
                int counter = 2;
                // for each pair of (i,j), check how many points are on the same line with them
                for (int k = j + 1; k < points.length; ++k) {
                    int[] pk = points[k];
                    if (a * (pk[1] - pi[1]) + b * (pk[0] - pi[0]) == 0) {
                        counter++;
                    }
                }
                max = Math.max(max, counter);
            }
        }
        return max;
    }
}

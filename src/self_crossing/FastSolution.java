package self_crossing;

public class FastSolution {
    public boolean isSelfCrossing(int[] distance) {
        if (distance.length <= 3) {
            return false;
        }
        for (int i = 3; i < distance.length; i++) {
            if (distance[i] >= distance[i - 2] && distance[i - 3] >= distance[i - 1]) {
                return true;
            }
            if (i >= 4 && distance[i - 1] == distance[i - 3] && distance[i - 2] <= distance[i] + distance[i - 4]) {
                return true;
            }
            if (i >= 5 && distance[i - 3] >= distance[i - 1] && distance[i - 1] >= distance[i - 3] - distance[i - 5]
                    && distance[i - 2] >= distance[i - 4]
                    && distance[i - 2] <= distance[i - 4] + distance[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new FastSolution().isSelfCrossing(new int[]{3, 3, 3, 2, 1, 1}));
    }
}

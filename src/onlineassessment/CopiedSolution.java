package onlineassessment;

import java.util.*;

public class CopiedSolution {

    private static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int cutOffTree(List<List<Integer>> forest) {

        List<int[]> treeHeights = getAllTreeHights(forest);
        Collections.sort(treeHeights, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        int minSteps = 0;
        int curX = 0, curY = 0;
        while (!treeHeights.isEmpty()) {
            int[] curTree = treeHeights.remove(0);
            int steps = getMinimumSteps(forest, curX, curY, curTree[0], curTree[1]);
            if (steps == -1) {
                return -1;
            }
            minSteps += steps;
            curX = curTree[0];
            curY = curTree[1];
            forest.get(curX).set(curY, 1);
        }
        return minSteps;
    }

    private int getMinimumSteps(List<List<Integer>> forest, int curX, int curY, int aimX, int aimY) {

        int minSteps = 0;
        int rows = forest.size(), cols = forest.get(0).size();
        boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
        Queue<int[]> queue = new LinkedList<>();
        int startVal = forest.get(curX).get(curY);
        queue.offer(new int[]{curX, curY});
        visited[curX][curY] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curCell = queue.poll();
                if (curCell[0] == aimX && curCell[1] == aimY) {
                    return minSteps;
                }
                for (int[] direction : directions) {
                    int nx = curCell[0] + direction[0];
                    int ny = curCell[1] + direction[1];
                    if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && !visited[nx][ny] && forest.get(nx).get(ny) != 0) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            minSteps++;
        }
        return -1;
    }

    private List<int[]> getAllTreeHights(List<List<Integer>> forest) {
        List<int[]> treeHeights = new LinkedList<>();
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(0).size(); j++) {
                int tmpVal = forest.get(i).get(j);
                if (tmpVal > 1) {
                    int[] element = new int[3];
                    element[0] = i;
                    element[1] = j;
                    element[2] = tmpVal;
                    treeHeights.add(element);
                }
            }
        }
        return treeHeights;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().cutOffTree(List.of(
//                new ArrayList<>(List.of(1, 2, 3)),
//                new ArrayList<>(List.of(0, 0, 4)),
//                new ArrayList<>(List.of(7, 6, 5)))));
//        System.out.println(new Solution().cutOffTree(List.of(
//                new ArrayList<>(List.of(1, 2, 3)),
//                new ArrayList<>(List.of(0, 0, 0)),
//                new ArrayList<>(List.of(7, 6, 5)))));
//        System.out.println(new Solution().cutOffTree(
//                List.of(
//                        new ArrayList<>(List.of(2395, 206, 0, 5388)),
//                        new ArrayList<>(List.of(4985, 2866, 0, 1789)),
//                        new ArrayList<>(List.of(0, 0, 7052, 0)),
//                        new ArrayList<>(List.of(0, 3029, 3327, 685)),
//                        new ArrayList<>(List.of(0, 0, 7846, 0)),
//                        new ArrayList<>(List.of(0, 0, 1542, 0)),
//                        new ArrayList<>(List.of(7577, 0, 2902, 623)),
//                        new ArrayList<>(List.of(2610, 9817, 0, 8198)))));
        System.out.println(new CopiedSolution().cutOffTree(List.of(
                new ArrayList<>(List.of(63750247, 40643210, 95516857, 89928134, 66334829, 58741187, 76532780, 45104329)),
                new ArrayList<>(List.of(3219401, 97566322, 9135413, 75944198, 93735601, 33923288, 50116695, 83660397)),
                new ArrayList<>(List.of(64460750, 53045740, 31903386, 78155821, 90848739, 38769489, 99349027, 85982891)),
                new ArrayList<>(List.of(30628785, 51077683, 70534803, 67460877, 91077770, 74197235, 5696362, 91459886)),
                new ArrayList<>(List.of(56105195, 82479378, 45937951, 52817583, 2768114, 43329099, 28189138, 21418604)))));

    }
}
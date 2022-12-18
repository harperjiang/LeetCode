package number_of_connected_components_in_undirected_graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, Integer> pointer = new HashMap<>();
        int[] comp = new int[n];
        Arrays.fill(comp, -1);
        int counter = 0;
        int end = 0;
        for (int[] edge : edges) {
            if (comp[edge[0]] == comp[edge[1]] && comp[edge[0]] == -1) {
                comp[edge[0]] = end;
                comp[edge[1]] = end++;
                counter++;
            }  else if (comp[edge[0]] == -1 || comp[edge[1]] == -1) {
                int existcomp = comp[edge[0]] + comp[edge[1]] + 1;
                comp[edge[0]] = existcomp;
                comp[edge[1]] = existcomp;
            } else {
                // Connect comp 0 to comp 1
                int bigger = comp[edge[0]] > comp[edge[1]] ? comp[edge[0]] : comp[edge[1]];
                int smaller = comp[edge[0]] + comp[edge[1]] - bigger;
                int bp = bigger;
                while (pointer.containsKey(bp)) bp = pointer.get(bp);
                while (pointer.containsKey(smaller)) smaller = pointer.get(smaller);
                if (bp != smaller) {
                    pointer.put(bigger, smaller);
                    if (bp > smaller) {
                        pointer.put(bp, smaller);
                    } else {
                        pointer.put(smaller, bp);
                    }
                    counter--;
                }
            }
        }
//        for (int i = 0; i < n; i++) {
//            while (pointer.containsKey(comp[i])) {
//                comp[i] = pointer.get(comp[i]);
//            }
//        }
        for (int c : comp) {
            if (c == -1) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countComponents(100, new int[][]{
                {6, 27}, {83, 9}, {10, 95}, {48, 67}, {5, 71}, {18, 72}, {7, 10}, {92, 4}, {68, 84}, {6, 41}, {82, 41}, {18, 54}, {0, 2}, {1, 2}, {8, 65}, {47, 85}, {39, 51}, {13, 78}, {77, 50}, {70, 56}, {5, 61}, {26, 56}, {18, 19}, {35, 49}, {79, 53}, {40, 22}, {8, 19}, {60, 56}, {48, 50}, {20, 70}, {35, 12}, {99, 85}, {12, 75}, {2, 36}, {36, 22}, {21, 15}, {98, 1}, {34, 94}, {25, 41}, {65, 17}, {1, 56}, {43, 96}, {74, 57}, {19, 62}, {62, 78}, {50, 86}, {46, 22}, {10, 13}, {47, 18}, {20, 66}, {83, 66}, {51, 47}, {23, 66}, {87, 42}, {25, 81}, {60, 81}, {25, 93}, {35, 89}, {65, 92}, {87, 39}, {12, 43}, {75, 73}, {28, 96}, {47, 55}, {18, 11}, {29, 58}, {78, 61}, {62, 75}, {60, 77}, {13, 46}, {97, 92}, {4, 64}, {91, 47}, {58, 66}, {72, 74}, {28, 17}, {29, 98}, {53, 66}, {37, 5}, {38, 12}, {44, 98}, {24, 31}, {68, 23}, {86, 52}, {79, 49}, {32, 25}, {90, 18}, {16, 57}, {60, 74}, {81, 73}, {26, 10}, {54, 26}, {57, 58}, {46, 47}, {66, 54}, {52, 25}, {62, 91}, {6, 72}, {81, 72}, {50, 35}, {59, 87}, {21, 3}, {70, 12}, {48, 4}, {9, 23}, {52, 55}, {43, 59}, {49, 26}, {25, 90}, {52, 0}, {55, 8}, {7, 23}, {97, 41}, {0, 40}, {69, 47}, {73, 68}, {10, 6}, {47, 9}, {64, 24}, {95, 93}, {79, 66}, {77, 21}, {80, 69}, {85, 5}, {24, 48}, {74, 31}, {80, 76}, {81, 27}, {71, 94}, {47, 82}, {3, 24}, {66, 61}, {52, 13}, {18, 38}, {1, 35}, {32, 78}, {7, 58}, {26, 58}, {64, 47}, {60, 6}, {62, 5}, {5, 22}, {60, 54}, {49, 40}, {11, 56}, {19, 85}, {65, 58}, {88, 44}, {86, 58}
        }));
    }
}
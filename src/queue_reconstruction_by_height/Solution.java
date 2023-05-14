package queue_reconstruction_by_height;

import java.util.*;

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Comparator compare = Comparator.comparing((int[] a) -> a[0]).thenComparing((int[] a) -> -a[1]);
        Arrays.sort(people, compare);

        // Adjust the place
        int pointer = people.length - 2;
        while (pointer >= 0) {
            int[] next = people[pointer];
            if (next[1] > 0) {
                System.arraycopy(people, pointer + 1, people, pointer, next[1]);
                people[pointer + next[1]] = next;
            }
            pointer--;
        }
        return people;
    }

    public static void main(String[] args) {
        new Solution().reconstructQueue(new int[][]{
                {7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}
        });
    }
}

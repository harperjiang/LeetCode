package nested_list_weight_sum_2;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    int maxdepth = -1;

    List<int[]> numbers = new ArrayList<>();

    void traverse(NestedInteger ni, int depth) {
        maxdepth = Math.max(depth, maxdepth);
        if (ni.isInteger()) {
            numbers.add(new int[]{ni.getInteger(), depth});
        } else {
            List<NestedInteger> nis = ni.getList();
            for (int i = 0; i < nis.size(); i++) {
                traverse(nis.get(i), depth + 1);
            }
        }
    }

    public int depthSumInverse(List<NestedInteger> nestedList) {
        maxdepth = -1;
        numbers.clear();

        for (NestedInteger ni : nestedList) {
            traverse(ni, 1);
        }

        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            int[] pair = numbers.get(i);
            sum += (maxdepth - pair[1]+1) * pair[0];
        }
        return sum;
    }
}

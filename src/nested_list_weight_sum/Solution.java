package nested_list_weight_sum;

import java.util.List;

public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return sum(nestedList, 1);
    }

    int sum(List<NestedInteger> target, int depth) {
        int sum = 0;
        for (NestedInteger n : target) {
            if (n.isInteger()) {
                sum += depth * n.getInteger();
            } else {
                sum += sum(n.getList(), depth + 1);
            }
        }
        return sum;
    }
}

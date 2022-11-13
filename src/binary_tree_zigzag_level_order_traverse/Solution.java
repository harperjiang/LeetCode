package binary_tree_zigzag_level_order_traverse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    List<Integer> inverse(List<Integer> list) {
        int middle = list.size() / 2;
        for (int i = 0; i < middle; ++i) {
            int temp = list.get(i);
            list.set(i, list.get(list.size() - 1 - i));
            list.set(list.size() - 1 - i, temp);
        }
        return list;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> buffer = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean inverse = false;
        while (!queue.isEmpty()) {
            int loopsize = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < loopsize; i++) {
                TreeNode head = queue.remove();
                if (head != null) {
                    level.add(head.val);
                    queue.add(head.left);
                    queue.add(head.right);
                }
            }
            if (!level.isEmpty()) {
                buffer.add(inverse ? inverse(level) : level);
            }
            inverse = !inverse;
        }
        return buffer;
    }
}

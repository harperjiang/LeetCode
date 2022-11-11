package binary_tree_level_order_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> buffer = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
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
            if(!level.isEmpty()) {
                buffer.add(level);
            }
        }
        return buffer;
    }
}

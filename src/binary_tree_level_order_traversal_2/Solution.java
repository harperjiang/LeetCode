package binary_tree_level_order_traversal_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> buffer;
        LinkedList<TreeNode> current = new LinkedList<>();
        current.add(root);
        while (!current.isEmpty()) {
            buffer = new ArrayList<>();
            int size = current.size();
            for (int i = 0; i < size; ++i) {
                TreeNode next = current.pop();
                if (next != null) {
                    buffer.add(next.val);
                    current.add(next.left);
                    current.add(next.right);
                }
            }
            if (!buffer.isEmpty())
                result.add(buffer);
        }
        Collections.reverse(result);
        return result;
    }
}

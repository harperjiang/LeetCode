package binary_tree_right_side_view;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    void scan(List<Integer> buffer, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level >= buffer.size())
            buffer.add(root.val);
        scan(buffer, root.right, level + 1);
        scan(buffer, root.left, level + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> buffer = new ArrayList<>();
        scan(buffer, root, 0);
        return buffer;
    }
}

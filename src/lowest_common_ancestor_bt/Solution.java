package lowest_common_ancestor_bt;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    void search(TreeNode root, TreeNode target1, TreeNode target2) {
        if (root == null) {
            return;
        }
        if (root.val == target1.val || root.val == target2.val) {
            counter++;
            if (counter == 1) {
                depth = path.size();
                common = root;
            }
            if (counter == 2) {
                return;
            }
        }
        path.add(root);

        search(root.left, target1, target2);
        if (counter < 2)
            search(root.right, target1, target2);
        path.remove(path.size() - 1);
        if (counter == 1) {
            depth = Math.min(depth, path.size());
            if (depth == path.size()) {
                common = path.get(path.size() - 1);
            }
        }
    }

    TreeNode common = null;
    int depth = 0;
    List<TreeNode> path = new ArrayList<>();

    int counter = 0;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        path.clear();
        counter = 0;
        depth = 0;
        search(root, p, q);
        return common;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        System.out.println(new Solution().lowestCommonAncestor(root, new TreeNode(5), new TreeNode(1)).val);
    }
}

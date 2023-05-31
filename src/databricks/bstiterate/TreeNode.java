package databricks.bstiterate;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode parent;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode parent) {
        this.val = val;
        this.parent = parent;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

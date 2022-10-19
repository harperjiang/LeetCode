package recovery_binary_search_tree;

/**
 * Created by harper on 10/15/17.
 */
class Solution {
    public void recoverTree(TreeNode root) {
        // The two misplaced tree nodes
        TreeNode[] buffer = new TreeNode[4];
        scan(root, null, buffer);

        if (buffer[0] != null && buffer[3] != null) {
            // Swap the value
            int temp = buffer[0].val;
            buffer[0].val = buffer[3].val;
            buffer[3].val = temp;
        } else if (buffer[0] != null && buffer[1] != null) {
            int temp = buffer[0].val;
            buffer[0].val = buffer[1].val;
            buffer[1].val = temp;
        } else if (buffer[2] != null && buffer[3] != null) {
            int temp = buffer[2].val;
            buffer[2].val = buffer[3].val;
            buffer[3].val = temp;
        }
    }

    protected void record(TreeNode[] buffer, TreeNode first, TreeNode second) {
        if (buffer[0] == null) {
            buffer[0] = first;
            buffer[1] = second;
        } else {
            buffer[2] = first;
            buffer[3] = second;
        }
    }

    // This scan return the last element in the subtree, and record
    // nodes in reverse order
    public TreeNode scan(TreeNode root, TreeNode prev, TreeNode[] buffer) {
        if (root == null)
            return null;

        if (root.left == null && root.right == null) {
            if (prev != null && prev.val > root.val) {
                record(buffer, prev, root);
            }
            return root;
        }
        TreeNode leftScan = scan(root.left, prev, buffer);
        if (leftScan != null && root.val < leftScan.val) {
            record(buffer, leftScan, root);
        } else if (prev != null && root.val < prev.val) {
            record(buffer, prev, root);
        }
        TreeNode rightScan = scan(root.right, root, buffer);
        return rightScan == null ? root : rightScan;
    }

}

package construct_binary_tree_from_inorder_and_postorder;

public class Solution {

    int i;
    int p;

    TreeNode build(int[] inorder, int[] postorder, int boundary) {
        if (p < 0 || inorder[i] == boundary) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[p--]);
        root.right = build(inorder, postorder, root.val);
        i--;
        root.left = build(inorder, postorder, boundary);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        i = inorder.length - 1;
        p = inorder.length - 1;
        return build(inorder, postorder, -3001);
    }
}

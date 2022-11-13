package construct_binary_tree_from_preorder_and_inorder;

public class Solution {

    int i, p;

    public TreeNode build(int[] preorder, int[] inorder, int boundary) {
        if (p == preorder.length || inorder[i] == boundary) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[p++]);
        root.left = build(preorder, inorder, root.val);
        i++;
        root.right = build(preorder, inorder, boundary);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        i = 0;
        p = 0;
        return build(preorder, inorder, 3001);
    }

    public static void main(String[] args) {
        new Solution().buildTree(new int[]{3, 1, 2, 4}, new int[]{1, 2, 3, 4});
    }
}

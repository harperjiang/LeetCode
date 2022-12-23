package largest_bst_subtree;

public class Solution {
    public int largestBSTSubtree(TreeNode root) {
        int[] checked = checkbst(root);
        return checked[3];
    }

    /**
     * @param root
     * @return {valid, smallest, largest, size}
     */
    int[] checkbst(TreeNode root) {
        if (root == null) {
            return new int[]{1, 10001, -10001, 0};
        }

        int[] leftres = checkbst(root.left);
        int[] rightres = checkbst(root.right);

        if (leftres[0] > 0 && rightres[0] > 0) { // Both subtrees are valid
            if (leftres[2] < root.val && rightres[1] > root.val) {
                return new int[]{1, Math.min(root.val, leftres[1]), Math.max(root.val, rightres[2]), leftres[3] + rightres[3] + 1};
            } else {
                return new int[]{0, 0, 0, Math.max(leftres[3], rightres[3])};
            }
        }
        return new int[]{0, 0, 0, Math.max(leftres[3], rightres[3])};
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(1);
        System.out.println(new Solution().largestBSTSubtree(root));
    }
}

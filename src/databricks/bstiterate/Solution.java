package databricks.bstiterate;

public class Solution {

    public void traverse(TreeNode root) {
        TreeNode pointer = root;
        int state = 0;
        // State 0: down from parent
        // State 1: left return to parent
        // State 2: right return to parent
        // State 3: done

        while (state != 3) {
            switch (state) {
                case 0:
                    while (pointer.left != null) pointer = pointer.left;
                    state = 1;
                    break;
                case 1:
                    System.out.println(pointer.val);
                    if (pointer.right != null) {
                        state = 0;
                        pointer = pointer.right;
                    } else {
                        // this branch is done, return to parent
                        if (pointer.parent == null) break;
                        if (pointer == pointer.parent.left) {
                            pointer = pointer.parent;
                        } else {
                            state = 2;
                            pointer = pointer.parent;
                        }
                    }
                    break;
                case 2:
                    if (pointer.parent == null) {
                        state = 3;
                        break;
                    }
                    if (pointer == pointer.parent.left) {
                        state = 1;
                        pointer = pointer.parent;
                    } else {
                        pointer = pointer.parent;
                    }
                    break;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5, root);
        root.right = new TreeNode(17, root);

        root.left.left = new TreeNode(2, root.left);
        root.left.right = new TreeNode(9, root.left);
        root.left.left.left = new TreeNode(1, root.left.left);
        root.left.right.left = new TreeNode(6, root.left.right);

        root.right.left = new TreeNode(16, root.right);
        root.right.right = new TreeNode(22, root.right);
        root.right.right.left = new TreeNode(19, root.right.right);

        new Solution().traverse(root);
    }
}

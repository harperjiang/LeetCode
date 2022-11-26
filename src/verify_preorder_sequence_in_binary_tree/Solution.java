package verify_preorder_sequence_in_binary_tree;

public class Solution {

    int verify(int[] preorder, int pointer, int lb, int ub) {
        if (pointer >= preorder.length) {
            return 0;
        }
        int root = preorder[pointer];
        if (root > ub || root < lb) {
            return 0;
        }
        int llength = verify(preorder, pointer + 1, lb, root);
        int rlength = verify(preorder, pointer + 1 + llength, root, ub);
        return llength + rlength + 1;
    }

    public boolean verifyPreorder(int[] preorder) {
        return preorder.length == verify(preorder, 0, -1, 10001);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().verifyPreorder(new int[]{5, 2, 1, 3, 6}));
    }
}

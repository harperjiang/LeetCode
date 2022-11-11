package unique_binary_search_trees;

import unique_binary_search_tree_2.TreeNode;

import java.util.*;

public class Solution {

    public int numTrees(int n) {
        int[] buffer = new int[n+1];
        Arrays.fill(buffer, 0);
        buffer[0] = 1;
        buffer[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                buffer[i] += buffer[j-1] * buffer[i - j];
            }
        }
        return buffer[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numTrees(3));
    }
}

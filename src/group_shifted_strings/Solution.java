package group_shifted_strings;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    static class TreeNode {
        TreeNode[] next = new TreeNode[26];
        List<String> group = null;
    }

    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        TreeNode root = new TreeNode();

        for (String string : strings) {
            TreeNode current = root;
            for (int i = 1; i < string.length(); ++i) {
                int diff = string.charAt(i) - string.charAt(i - 1);
                if (diff < 0) {
                    diff += 26;
                }
                if (current.next[diff] == null) {
                    current.next[diff] = new TreeNode();
                }
                current = current.next[diff];
            }
            if (current.group == null) {
                current.group = new ArrayList<>();
                result.add(current.group);
            }
            current.group.add(string);
        }

        return result;
    }
}

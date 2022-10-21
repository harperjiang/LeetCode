package generate_parenthesis;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> container = new ArrayList<>();
        dfs(0, 0, new StringBuilder(), n, container);
        return container;
    }

    void dfs(int left, int right, StringBuilder current, int n, List<String> container) {
        if (current.length() == 2 * n) {
            container.add(current.toString());
            return;
        }
        if (left < n) {
            current.append("(");
            dfs(left + 1, right, current, n, container);
            current.deleteCharAt(current.length() - 1);
        }
        if (right < left) {
            current.append(")");
            dfs(left, right + 1, current, n, container);
            current.deleteCharAt(current.length() - 1);
        }
    }


    public static void main(String[] args) {
//        System.out.println(new Solution().generateParenthesis(2));
//        System.out.println(new Solution().generateParenthesis(3));
        System.out.println(new Solution().generateParenthesis(4));
    }
}

package simplify_path;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public String simplifyPath(String path) {
        String[] parts = path.split("\\/");
        List<String> paths = new ArrayList<>();
        for (String part : parts) {
            if (part.equals("")) {
                // ignore
            } else if (part.equals("..")) {
                if (!paths.isEmpty())
                    paths.remove(paths.size() - 1);
            } else if (part.equals(".")) {
                // ignore
            } else {
                paths.add(part);
            }
        }
        return "/" + paths.stream().collect(Collectors.joining("/"));
    }

    public static void main(String[] args) {
        System.out.println(new Solution().simplifyPath("/home/"));
        System.out.println(new Solution().simplifyPath("/home//foo/"));
    }
}

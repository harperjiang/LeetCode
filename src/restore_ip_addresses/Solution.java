package restore_ip_addresses;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    String mkstr(String s, List<Integer> dotpos) {
        StringBuilder b = new StringBuilder();
        int prev = 0;
        for (int dp : dotpos) {
            b.append(s, prev, dp);
            b.append('.');
            prev = dp;
        }
        int last = dotpos.get(dotpos.size() - 1);
        b.append(s, last, s.length());
        return b.toString();
    }

    boolean valid(String s, int start, int end) {
        // length <= 3
        // do not start with 0
        // number <= 255
        if (end <= start || end - start > 3) {
            return false;
        }
        if (s.charAt(start) == '0') {
            return start == end - 1;
        }
        int sum = 0;
        for (int i = start; i < end; ++i) {
            sum = sum * 10 + (s.charAt(i) - '0');
            if (sum > 255) {
                return false;
            }
        }
        return true;
    }

    void dfs(List<String> result, String s, List<Integer> path) {
        int lastpos = path.isEmpty() ? 0 : path.get(path.size() - 1);
        for (int i = lastpos + 1; i <= Math.min(lastpos + 3,s.length()-1); ++i) {
            if (valid(s, lastpos, i)) {
                if (path.size() == 2) {
                    // Last one, extra check
                    if (valid(s, i, s.length())) {
                        path.add(i);
                        result.add(mkstr(s, path));
                        path.remove(path.size() - 1);
                    }
                } else {
                    path.add(i);
                    dfs(result, s, path);
                    path.remove(path.size() - 1);
                }
            }
        }
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(result, s, path);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().restoreIpAddresses("25525511135"));
        System.out.println(new Solution().restoreIpAddresses("0000"));
        System.out.println(new Solution().restoreIpAddresses("101023"));
    }
}

package regular_exp_matching;

import java.util.*;

public class Solution2 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for(int j = 1; j<=n;j++) {
            if(p.charAt(j-1) == '*');
            dp[0][j] |= dp[0][j - 2];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] |= dp[i][j - 2];
                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
                        dp[i][j] |= dp[i - 1][j - 2];
                        dp[i][j] |= dp[i - 1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
//        System.out.println(new Solution2().isMatch("mississippi", "mis*is*p*."));
//        System.out.println(new Solution2().isMatch("aa", "a*"));
//        System.out.println(new Solution2().isMatch("aab", "c*a*b"));
        System.out.println(new Solution2().isMatch("ab", ".*"));
    }
}

package interleaving_string;

public class Solution2 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        if(m+n!=s3.length()) {
            return false;
        }
        if(m==0) {
            return s2.equals(s3);
        }
        if(n==0) {
            return s1.equals(s3);
        }
        // dp[i][j] means the substring s1[0:i]+s2[0:j] is a prefix
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        dp[1][0] = s1.charAt(0) == s3.charAt(0);
        dp[0][1] = s2.charAt(0) == s3.charAt(0);

        for(int i = 0;i<=m;i++) {
            for(int j = 0 ; j <= n;j++) {
                if(i-1>=0) {
                    if(s1.charAt(i-1) == s3.charAt(i+j-1) && dp[i-1][j]) {
                        dp[i][j] = true;
                    }
                }
                if(j-1>=0) {
                    if(s2.charAt(j-1) == s3.charAt(i+j-1) && dp[i][j-1]) {
                        dp[i][j] = true;
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        new Solution2().isInterleave("aabcc","dbbca","aadbbcbcac");
    }
}

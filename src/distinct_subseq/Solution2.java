package distinct_subseq;

public class Solution2 {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        // dp[i][j] is the number of distinct subseqs in s.substring(0, i) that equals t.substring(0, j)
        int[][] dp = new int[m+1][n+1];

        for(int i = 0 ; i <= m ;i++) {
            for(int j = 0; j <= n;j++) {
                if(i < j) {
                    dp[i][j] = 0;
                } else if(i == j) {
                    dp[i][j] = s.substring(0,i).equals(t.substring(0,j))?1:0;
                } else {
                    dp[i][j] += dp[i-1][j];
                    if(i>=1 && j>= 1 && s.charAt(i-1)==t.charAt(j-1)) {
                        dp[i][j] += dp[i-1][j-1];
                    }
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        new Solution2().numDistinct("rabbbit", "rabbit");
    }
}

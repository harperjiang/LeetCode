package interleaving_string;

/**
 * Created by harper on 10/14/17.
 */
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length())
            return false;
        if (s1.length() == 0)
            return s2.equals(s3);
        if (s2.length() == 0)
            return s1.equals(s3);

        // Build a 2d table, table[i][j] means whether the first i chars of s1 and the first j chars from s2
        // forms a prefix of s3
        boolean table1[] = new boolean[s2.length() + 1];
        boolean table2[] = new boolean[s2.length() + 1];

        table1[0] = true;

        for (int i = 1; i <= s2.length(); i++) {
            table1[i] = s3.startsWith(s2.substring(0, i));
        }

        for (int i = 1; i <= s1.length(); i++) {
            table2[0] = s3.startsWith(s1.substring(0, i));
            for (int j = 1; j <= s2.length(); j++) {
                table2[j] = (table1[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (table2[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
            System.arraycopy(table2,0,table1,0,s2.length()+1);
        }

        return table2[s2.length()];
    }

}

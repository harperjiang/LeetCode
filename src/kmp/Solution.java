package kmp;

public class Solution {

    int[] build(String s) {
        int[] result = new int[s.length()];
        result[0] = 0;
        result[1] = 0;
        for (int i = 2; i < s.length(); i++) {
            int m = result[i - 1];
            while (m > 0 && s.charAt(i) != s.charAt(m)) {
                m = result[m];
            }
            if (m == 0)
                result[i] = s.charAt(i) == s.charAt(0) ? 1 : 0;
            else {
                result[i] = m + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().kmp("aabbcadsefwewioawjefiawa","sefwewi"));
    }

    public int kmp(String source, String match) {
        int[] index = build(match);
        int sp = 0;
        int mp = 0;
        while (sp < source.length()) {
            if (source.charAt(sp) == match.charAt(mp)) {
                sp++;
                mp++;
                if (mp == match.length()) {
                    return sp - match.length();
                }
            } else {
                if (mp == 0) {
                    sp++;
                } else {
                    mp = index[mp];
                }
            }
        }
        return -1;
    }
}

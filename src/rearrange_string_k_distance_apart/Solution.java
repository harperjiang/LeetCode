package rearrange_string_k_distance_apart;

import java.util.*;

public class Solution {
    public String rearrangeString(String s, int k) {
        if (k == 0 || k == 1) {
            return s;
        }
        int[] counter = new int[26];
        int max = 0;
        for (char c : s.toCharArray()) {
            int cindex = c - 'a';
            counter[cindex]++;
            max = Math.max(max, counter[cindex]);
        }
        if (max * (k - 1) > s.length()) {
            return "";
        }

        char[] buffer = new char[s.length()];

        boolean[] include = new boolean[26];
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] != 0) {
                include[i] = true;
            }
        }

        for (int i = 0; i < buffer.length; i++) {
            int next = -1;
            int nmax = 0;
            if (i >= k) {
                include[buffer[i - k] - 'a'] = true;
            }
            for (int j = 0; j < 26; j++) {
                if (include[j] && nmax < counter[j]) {
                    next = j;
                    nmax = counter[j];
                }
            }
            if (next == -1) {
                return "";
            }
            buffer[i] = (char) ('a' + next);
            counter[next]--;
            include[next] = false;
        }

        return new String(buffer);
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().rearrangeString("a", 0));
//        System.out.println(new Solution().rearrangeString("aabbcc", 3));
        System.out.println(new Solution().rearrangeString("aaab", 2));
//        System.out.println(new Solution().rearrangeString("aaabc", 3));
//        System.out.println(new Solution().rearrangeString("aaadbbcc", 2));
//        System.out.println(new Solution().rearrangeString("abb", 2));
//        System.out.println(new Solution().rearrangeString("bbabcaccaaabababbaaaaccbbcbacbacacccbbcaabcbcacaaccbabbbbbcacccaccbabaccbacabcabcacb", 2));
    }
}

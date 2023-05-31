package lc466;

public class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int[] nextidx = new int[s1.length()];
        int[] repinc = new int[s1.length()];

        for (int i = 0; i < s1.length(); i++) {
            int j = i;
            int k = 0;
            while (k < s2.length()) {
                if (s1.charAt(j % s1.length()) == s2.charAt(k)) {
                    k++;
                }
                j++;
                if(j-i > s1.length() && k == 0) return 0;
            }
            nextidx[i] = j % s1.length();
            repinc[i] = j / s1.length();
        }
        int s2count = 0;
        int pointer = 0;
        int loop = 0;
        while (loop < n1) {
            loop += repinc[pointer];
            pointer = nextidx[pointer];
            if (loop >= n1 && pointer >0) break;
            s2count++;
        }

        return s2count / n2;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().getMaxRepetitions("acb", 4, "ab", 2));
//        System.out.println(new Solution().getMaxRepetitions("aaa", 3, "aa", 1));
//        System.out.println(new Solution().getMaxRepetitions("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 1000000,
//                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 103));
//        System.out.println(new Solution().getMaxRepetitions("caahumeayllfdxfircvscxggbwkfnqduxwfnfozvsrtkjprepggxrpnrvystmwcysyycqpevikeffmznimkkasvwsrenazkycxaa",
//                1000000, "aac", 100));
        System.out.println(new Solution().getMaxRepetitions("musicforever",10,"lovelive",100000));
    }
}

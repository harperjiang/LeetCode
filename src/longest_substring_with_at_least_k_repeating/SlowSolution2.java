package longest_substring_with_at_least_k_repeating;

public class SlowSolution2 {
    public int longestSubstring(String s, int k) {
        int[][] buffer = new int[s.length() + 1][26];
        for (int i = 1; i < buffer.length; i++) {
            System.arraycopy(buffer[i - 1], 0, buffer[i], 0, 26);
            buffer[i][s.charAt(i - 1) - 'a']++;
        }
        for (int span = s.length(); span > 0; span--) {
            for (int i = 0; i + span <= s.length(); i++) {
                int[] base = buffer[i + span];
                int[] sub = buffer[i];
                boolean match = true;
                for (int idx = 0; idx < 26; idx++) {
                    int diff = base[idx] - sub[idx];
                    if (diff > 0 && diff < k) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return span;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new SlowSolution2().longestSubstring("aaabb", 3));
        System.out.println(new SlowSolution2().longestSubstring("ababbc", 2));
        System.out.println(new SlowSolution2().longestSubstring("ababacb", 3));
        System.out.println(new SlowSolution2().longestSubstring("aaaaaaaaaaaabcdefghijklmnopqrstuvwzyz", 3));
        System.out.println(new SlowSolution2().longestSubstring("bchhbbdefghiaaacb", 3));
        System.out.println(new SlowSolution2().longestSubstring("zzzzzzzzzzaaaaaaaaabbbbbbbbhbhbhbhbhbhbhicbcbcibcbccccccccccbbbbbbbbaaaaaaaaafffaahhhhhiaahiiiiiiiiifeeeeeeeeee", 10));
    }
}

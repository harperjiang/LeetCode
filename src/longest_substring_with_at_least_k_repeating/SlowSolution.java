package longest_substring_with_at_least_k_repeating;

public class SlowSolution {
    public int longestSubstring(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int bitmap = 0xFFFFFFFF;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0 && freq[i] < k) {
                bitmap &= ~(1 << i);
            }
        }
        if (bitmap == 0xFFFFFFFF) {
            return s.length();
        }

        int[] runtime = new int[26];

        for (int span = s.length() - 1; span > 0; span--) {
            // Remove last char

            int last = s.charAt(span) - 'a';
            freq[last]--;
            if (freq[last] == 0 || freq[last] >= k) {
                bitmap |= (1 << last);
            } else {
                bitmap &= ~(1 << last);
            }
            if (bitmap == 0xFFFFFFFF) {
                return span;
            }
            System.arraycopy(freq, 0, runtime, 0, 26);
            int back = bitmap;
            for (int i = 1; i <= s.length() - span; i++) {
                int removechar = s.charAt(i - 1) - 'a';
                int addchar = s.charAt(i + span - 1) - 'a';
                runtime[removechar]--;
                runtime[addchar]++;
                if (runtime[removechar] == 0 || runtime[removechar] >= k) {
                    bitmap |= (1 << removechar);
                } else {
                    bitmap &= ~(1 << removechar);
                }
                if (runtime[addchar] >= k) {
                    bitmap |= (1 << addchar);
                } else {
                    bitmap &= ~(1 << addchar);
                }
                if (bitmap == 0xFFFFFFFF) {
                    return span;
                }
            }
            bitmap = back;
        }
        return 0;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().longestSubstring("aaabb", 3));
//        System.out.println(new Solution().longestSubstring("ababbc",2));
//        System.out.println(new Solution().longestSubstring("ababacb",3));
//        System.out.println(new Solution().longestSubstring("aaaaaaaaaaaabcdefghijklmnopqrstuvwzyz",3));
//        System.out.println(new Solution().longestSubstring("bchhbbdefghiaaacb",3));
        System.out.println(new SlowSolution().longestSubstring("zzzzzzzzzzaaaaaaaaabbbbbbbbhbhbhbhbhbhbhicbcbcibcbccccccccccbbbbbbbbaaaaaaaaafffaahhhhhiaahiiiiiiiiifeeeeeeeeee", 10));
    }
}

package longest_substring_with_atmostk_distinct_char;

public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] charcounter = new int[256];
        int distinctcounter = 0;
        int start = 0;
        int maxlength = 0;
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            int cindex = s.charAt(i);
            charcounter[cindex]++;
            length++;
            if (charcounter[cindex] == 1) {
                distinctcounter++;
                while (start < s.length() && distinctcounter > k) {
                    // Need to move start until distinctcounter <= k
                    int sindex = s.charAt(start);
                    charcounter[sindex]--;
                    if (charcounter[sindex] == 0) {
                        distinctcounter--;
                    }
                    start++;
                    length--;
                }
            }
            if(length>maxlength) {
                maxlength = length;
            }
        }
        return maxlength;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstringKDistinct("eceba", 2));
        System.out.println(new Solution().lengthOfLongestSubstringKDistinct("abee", 1));
    }
}

package maximum_xor;

import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int findMaximumXOR(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int max = -1;
        for (int num : nums) {
            for (int i = 31; i >= 0; i--) {
                if (((1 << i) & num) > 0) {
                    if (i > max) max = i;
                    break;
                }
            }
        }

        int maxor = 0;
        for (int i = max ; i >= 0; i--) {
            maxor <<= 1;
            int masked = maxor + 1;
            HashSet<Integer> prefixes = new HashSet<>();
            for (int num : nums) {
                int prefix = num >> i;
                prefixes.add(prefix);
            }
            for (int num : nums) {
                int prefix = num >> i;
                if (prefixes.contains(prefix ^ masked)) {
                    maxor = masked;
                    break;
                }
            }
        }
        return maxor;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
        System.out.println(new Solution().findMaximumXOR(new int[]{14,70,53,83,49,91,36,80,92,51,66,70}));
        System.out.println(new Solution().findMaximumXOR(new int[]{0, 8}));
        System.out.println(new Solution().findMaximumXOR(new int[]{4, 6, 7}));
        System.out.println(new Solution().findMaximumXOR(new int[]{14, 15, 9, 3, 2}));
        System.out.println(new Solution().findMaximumXOR(new int[]{15, 15, 9, 3, 2}));
    }
}

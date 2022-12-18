package coin_change;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public int coinChange(int[] coins, int amount) {
        int[] accu = new int[amount + 1];
        Arrays.fill(accu, amount + 1);
        accu[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                int index = i + coins[j];
                if (index>=0 && index < accu.length)
                    accu[index] = Math.min(accu[index], accu[i] + 1);
            }
        }
        if (accu[amount] != amount+1) {
            return accu[amount];
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().coinChange(new int[]{1, 2, 5}, 11));
//        System.out.println(new Solution().coinChange(new int[]{2}, 3));
//        System.out.println(new Solution().coinChange(new int[]{1}, 0));
//        System.out.println(new Solution().coinChange(new int[]{2147483647}, 2));
//        System.out.println(new Solution().coinChange(new int[]{1, 2147483647}, 2));
//        System.out.println(new Solution().coinChange(new int[]{411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422}, 9864));
    }
}

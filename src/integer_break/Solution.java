package integer_break;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int integerBreak(int n) {
        int max = 0;
        for (int i = 2; i <= n; i++) {
            int newmax = splitandmul(n, i);
            if (newmax > max) {
                max = newmax;
            } else {
                return max;
            }
        }
        return max;
    }

    int splitandmul(int n, int k) {
        int base = n / k;
        int remain = n % k;
        int res = 1;
        for (int i = 0; i < remain; i++) {
            res *= (base + 1);
        }
        for (int i = remain; i < k; i++) {
            res *= base;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().integerBreak(2));
        System.out.println(new Solution().integerBreak(10));
    }
}

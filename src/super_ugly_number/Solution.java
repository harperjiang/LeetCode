package super_ugly_number;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] pointers = new int[primes.length];
        List<Integer> results = new ArrayList<>();
        results.add(1);
        while (results.size() < n) {
            int last = results.get(results.size() - 1);
            int min = Integer.MAX_VALUE;
            int midx = -1;
            for (int i = 0; i < primes.length; i++) {
                int next = primes[i] * results.get(pointers[i]);
                if (next < 0) {//overflow
                    continue;
                }
                if (next == last) {
                    pointers[i]++;
                    next = primes[i] * results.get(pointers[i]);
                    if(next<0) {
                        continue;
                    }
                }
                if (next < min) {
                    min = next;
                    midx = i;
                }
            }
            results.add(min);
            pointers[midx]++;
        }
        System.out.println(results);
        return results.get(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().nthSuperUglyNumber(1719, new int[]{2, 7,13,19}));
    }
}

package count_primes;

public class Solution {
    int[] known = new int[]{0, 0, 0, 1, 2, 2, 3};

    public int countPrimes(int n) {
        if (n <= 6) {
            return known[n];
        }
        boolean[] filter = new boolean[n];
        filter[3] = false;
        filter[5] = false;
        for (int i = 3; i < n; i += 2) {
            if (!filter[i]) {
                int k = 2*i;
                while (k < n) {
                    filter[k] = true;
                    k += i;
                }
            }
        }
        int counter = 1;
        for(int i = 3; i < n;i+=2) {
            counter+= filter[i]?0:1;
        }
        return counter;
    }
}

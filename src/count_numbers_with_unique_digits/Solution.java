package count_numbers_with_unique_digits;

public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        return 9 * P(9, n - 1) + countNumbersWithUniqueDigits(n - 1);
    }

    int P(int a, int b) {
        int top = 1;
        for (int i = 1; i <= b; i++) {
            top *= (a - b + i);
        }
        return top;
    }
}

package lexicographical_numbers;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> lexicalOrder(int n) {
        int numDigits = String.valueOf(n).length();
        List<Integer> result = new ArrayList<>();
        int current = 1;
        for (int i = 0; i < n; i++) {
            result.add(current);

            if (current * 10 <= n) {
                current *= 10;
            } else {
                if (current + 1 <= n) {
                    current += 1;
                } else {
                    current /= 10;
                    current += 1;
                }
                while (current % 10 == 0) current /= 10;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print(new Solution().lexicalOrder(100));
    }
}

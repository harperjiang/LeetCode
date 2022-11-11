package gray_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> grayCode(int n) {
        if (n == 1) {
            return List.of(0, 1);
        }
        if (n == 2) {
            return List.of(0, 1, 3, 2);
        }
        List<Integer> result = new ArrayList<>(grayCode(2));
        for (int i = 3; i <= n; ++i) {
            int size = result.size();
            for (int j = size - 1; j >= 0; --j) {
                result.add(result.get(j) | (1 << (i - 1)));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().grayCode(3));
    }
}

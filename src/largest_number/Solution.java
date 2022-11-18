package largest_number;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public String largestNumber(int[] nums) {
        List<Integer> digits = new ArrayList<>();
        for (int n : nums) {
            digits.add(n);
        }
        Collections.sort(digits, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                int size = s1.length() + s2.length();
                for (int i = 0; i < size; ++i) {
                    int c1 = i >= s1.length() ? s2.charAt(i - s1.length()) : s1.charAt(i);
                    int c2 = i >= s2.length() ? s1.charAt(i - s2.length()) : s2.charAt(i);
                    if (c1 > c2) return -1;
                    if (c1 < c2) return 1;
                }
                return 0;
            }
        });
        return digits.stream().map(i -> String.valueOf(i)).collect(Collectors.joining()).replaceFirst("^0+", "0");
    }

    public static void main(String[] args) {
        System.out.println(new Solution().largestNumber(new int[]{3, 30, 34, 5, 9}));
    }
}

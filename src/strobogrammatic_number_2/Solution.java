package strobogrammatic_number_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> findStrobogrammatic(int n) {
        LinkedList<String> results = new LinkedList<>();
        for (int i = n % 2; i <= n; i += 2) {
            if (i == 0) {
                results.add("");
            } else if (i == 1) {
                results.addAll(List.of("0", "1", "8"));
            } else {
                // No 0 here
                int size = results.size();
                for (int j = 0; j < size; ++j) {
                    String prev = results.pop();
                    results.add("1" + prev + "1");
                    results.add("8" + prev + "8");
                    results.add("6" + prev + "9");
                    results.add("9" + prev + "6");
                    if (i != n - 1 && i != n) {
                        results.add("0" + prev + "0");
                    }
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findStrobogrammatic(3));
        System.out.println(new Solution().findStrobogrammatic(2));
        System.out.println(new Solution().findStrobogrammatic(1));
    }

}

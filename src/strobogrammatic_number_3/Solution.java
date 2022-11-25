package strobogrammatic_number_3;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public int strobogrammaticInRange(String low, String high) {
        if (high.compareTo("0") == 0 && low.compareTo("0") == 0) {
            return 1;
        }
        int lowcount = low.length();
        int highcount = high.length();

        LinkedList<String> evenResults = new LinkedList<>();
        LinkedList<String> oddResults = new LinkedList<>();
        int n = highcount;
        int counter = 0;
        for (int i = 0; i <= n; i++) {
            LinkedList<String> results = i % 2 == 0 ? evenResults : oddResults;
            if (i == 0) {
                evenResults.add("");
            } else if (i == 1) {
                oddResults.addAll(List.of("0", "1", "8"));
            } else {
                // No 0 here
                int size = results.size();
                for (int j = 0; j < size; ++j) {
                    String prev = results.pop();
                    results.add("1" + prev + "1");
                    results.add("6" + prev + "9");
                    results.add("8" + prev + "8");
                    results.add("9" + prev + "6");
                    if (i != n - 1 && i != n) {
                        results.add("0" + prev + "0");
                    }
                }
            }
            if (i == lowcount && i == highcount) {
                counter += results.stream().filter(s -> s.compareTo(low) >= 0 && s.compareTo(high) <= 0).count();
            } else if (i == lowcount) {
                counter += results.stream().filter(s -> s.compareTo(low) >= 0).count();
            } else if (i == highcount) {
                counter += results.stream().filter(s -> s.compareTo(high) <= 0).count();
            }
            if (i > lowcount && i < highcount) {
                counter += results.stream().filter(s -> !s.startsWith("0")).count();
            }
        }
        return counter;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().strobogrammaticInRange("50","100"));
        System.out.println(new Solution().strobogrammaticInRange("0", "0"));
        System.out.println(new Solution().strobogrammaticInRange("1", "1"));
        System.out.println(new Solution().strobogrammaticInRange("0", "1680"));
    }
}

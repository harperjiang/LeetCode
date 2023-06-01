package strong_password_checker;

import java.util.*;

public class Solution {
    static int[] NT = {0, 1, 1, 2, 1, 2, 2, 3};

    public int strongPasswordChecker(String password) {
        System.out.println(password);
        System.out.println(password.length());
        Set<Character> distinct = new HashSet<>();
        for (char c : password.toCharArray()) {
            distinct.add(c);
        }
        int type = 0;
        // Types of chars
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                type |= 1;
            }
            if (Character.isLowerCase(c)) {
                type |= 2;
            }
            if (Character.isUpperCase(c)) {
                type |= 4;
            }
        }
        int nt = 3 - NT[type];
        if (password.length() < 6) {
            if (password.length() == 5 && distinct.size() == 1) return 2;
            return 6 - password.length();
        } else if (password.length() <= 20) {
            // Scan for 3 consecutive
            int counter = 0;
            for (int i = 0; i < password.length() - 2; ) {
                if (password.charAt(i) == password.charAt(i + 1) && password.charAt(i + 1) == password.charAt(i + 2)) {
                    i += 3;
                    counter++;
                } else {
                    i++;
                }
            }
            return (counter > nt) ? counter : nt;
        } else {
            int toremove = password.length() - 20;
            int over3 = 0;
            PriorityQueue<Object[]> rle = new PriorityQueue<>(
                    Comparator.comparing((Object[] o) -> ((Integer) o[1]) % 3));
            char last = password.charAt(0);
            int lastcount = 1;
            for (int i = 1; i < password.length(); i++) {
                char c = password.charAt(i);
                if (c == last) {
                    lastcount++;
                } else {
                    if (lastcount >= 3) {
                        rle.add(new Object[]{last, lastcount});
                        over3++;
                    }
                    last = c;
                    lastcount = 1;
                }
            }
            if (lastcount >= 3) {
                rle.add(new Object[]{last, lastcount});
                over3++;
            }

            int step = 0;
            while (toremove > 0 && !rle.isEmpty()) {
                Object[] next = rle.poll();
                int now = (Integer) next[1] - 1;
                step++;
                toremove--;
                if (now >= 3) {
                    rle.add(new Object[]{next[0], now});
                }
            }

            // Still more than 20 but no more over 3
            if (rle.isEmpty()) {
                step += toremove;
            }
            // Now less than 20, fix all over 3
            int replace = 0;
            if (toremove == 0) {
                for (Object[] r : rle) {
                    int remain = (Integer) r[1];
                    step += remain / 3;
                    replace += remain / 3;
                }
            }
            if (replace < nt) step += nt - replace;
            return step;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().strongPasswordChecker("ABABABABABABABABABAB1"));
    }
}

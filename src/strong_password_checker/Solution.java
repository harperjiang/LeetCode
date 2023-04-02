package strong_password_checker;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    static int[] NT = {0,1,1,2,1,2,2,3};
    public int strongPasswordChecker(String password) {
        System.out.println(password);
        Set<Character> distinct = new HashSet<>();
        for(char c: password.toCharArray()) {
            distinct.add(c);
        }
        int type = 0;
        // Types of chars
        for(char c: password.toCharArray()) {
            if(Character.isDigit(c)) {
                type |= 1;
            }
            if(Character.isLowerCase(c)) {
                type |= 2;
            }
            if(Character.isUpperCase(c)) {
                type |= 4;
            }
        }
        int nt = 3 - NT[type];
        if(password.length() < 6) {
            if(password.length() == 5 && distinct.size() == 1) return 2;
            return 6 - password.length();
        } else if(password.length() <= 20) {
            // Scan for 3 consecutive
            int counter = 0;
            for(int i = 0 ; i < password.length()-2;) {
                if(password.charAt(i) == password.charAt(i+1) && password.charAt(i+1)==password.charAt(i+2)) {
                    i+=3;
                    counter ++;
                } else {
                    i++;
                }
            }
            return (counter> nt)?counter:nt;
        } else {
            int maxremove = password.length() - 20;
            int remove = 0;
            StringBuilder nsb = new StringBuilder();
            for(int i = 0 ; i < password.length();) {
                if(i< password.length()-2 && remove < maxremove && password.charAt(i) == password.charAt(i+1) && password.charAt(i+1)==password.charAt(i+2)) {
                    nsb.append(password.charAt(i));
                    nsb.append(password.charAt(i));
                    i+=3;
                    remove++;
                } else {
                    nsb.append(password.charAt(i));
                    i++;
                }
            }
            // Did not remove anything
            if(nsb.length() == password.length()) {
                return nsb.length() - 20 + nt;
            }
            return remove+strongPasswordChecker(nsb.toString());
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().strongPasswordChecker("bbaaaaaaaaaaaaaaacccccc"));
    }
}

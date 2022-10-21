package letter_combination_phone_number;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> letterCombinations(String digits) {
        char[] T_START = new char[]{0, 0, 'a', 'd', 'g', 'j', 'm', 'p', 't', 'w'};
        int[] T_LIMIT = new int[]{0, 0, 'c', 'f', 'i', 'l', 'o', 's', 'v', 'z'};
        List<String> results = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < digits.length(); ++i) {
            buffer.append(T_START[digits.charAt(i) - '0']);
        }
        int pointer = digits.length() - 1;
        while (pointer >= 0) {
            if (pointer == digits.length() - 1) {
                results.add(buffer.toString());
            }
            // Increase the digits the pointer points to by 1, if limit is reached, deduct the pointer by 1
            char newchar = (char) (buffer.charAt(pointer) + 1);
            int digit = (digits.charAt(pointer) - '0');
            int limit = T_LIMIT[digit];
            if (newchar > limit) {
                buffer.setCharAt(pointer, (char) (T_START[digit]));
                pointer -= 1;
            } else {
                buffer.setCharAt(pointer, newchar);
                for (int i = pointer + 1; i < digits.length(); i++) {
                    buffer.setCharAt(i, T_START[digits.charAt(i) - '0']);
                }
                pointer = digits.length() - 1;
            }
        }
        return results;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("2"));
        System.out.println(new Solution().letterCombinations("7"));
        System.out.println(new Solution().letterCombinations("23"));
        System.out.println(new Solution().letterCombinations(""));
        System.out.println(new Solution().letterCombinations("234"));
    }
}

package integer_to_roman;

public class Solution {
    public String intToRoman(int num) {
        int thousand = num / 1000;
        num %= 1000;
        int hundred = num / 100;
        num %= 100;
        int ten = num / 10;
        int one = num % 10;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < thousand; ++i) {
            builder.append("M");
        }
        if (hundred == 4) {
            builder.append("CD");
        } else if (hundred == 9) {
            builder.append("CM");
        } else {
            if (hundred >= 5) {
                builder.append("D");
                hundred -= 5;
            }
            for (int i = 0; i < hundred; ++i) {
                builder.append("C");
            }
        }

        if (ten == 4) {
            builder.append("XL");
        } else if (ten == 9) {
            builder.append("XC");
        } else {
            if (ten >= 5) {
                builder.append("L");
                ten -= 5;
            }
            for (int i = 0; i < ten; ++i) {
                builder.append("X");
            }
        }

        if (one == 4) {
            builder.append("IV");
        } else if (one == 9) {
            builder.append("IX");
        } else {
            if (one >= 5) {
                builder.append("V");
                one -= 5;
            }
            for (int i = 0; i < one; ++i) {
                builder.append("I");
            }
        }

        return builder.toString();
    }
}

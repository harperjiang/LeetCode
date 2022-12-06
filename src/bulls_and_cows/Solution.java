package bulls_and_cows;

import java.text.MessageFormat;
import java.util.Arrays;

public class Solution {
    public String getHint(String secret, String guess) {
        int[][] counter = new int[10][2];
        int magic = secret.length() + 1;
//        Arrays.fill(counter, magic);
        int a = 0;
        for (int i = 0; i < secret.length(); i++) {
            int expect = guess.charAt(i) - '0';
            int real = secret.charAt(i) - '0';
            if (expect == real) {
                a++;
            } else {
                counter[real][0]--;
                counter[expect][1]++;
            }
        }
        int b = 0;
        for (int[] i : counter) {
            if (i[0] + i[1] >= 0) {
                b += -i[0];
            } else {
                b += i[1];
            }
        }

        return a + "A" + b + "B";
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getHint("1122", "0001"));
        System.out.println(new Solution().getHint("1122", "2211"));
    }
}

package reverse_integer;

public class Solution {

    public int reverse(int x) {
        String numString = Integer.toString(x);
        boolean hasNeg = false;
        if (numString.startsWith("-")) {
            hasNeg = true;
            numString = numString.substring(1);
        }
        // Reverse numString
        boolean startZero = true;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numString.length(); ++i) {
            char c = numString.charAt(numString.length() - 1 - i);
            if (!(c == '0' && startZero)) {
                startZero = false;
                builder.append(c);
            }
        }
        String revString = builder.toString();
        if (hasNeg) {
            revString = "-" + revString;
        }
        if (revString.length() == 0) {
            return 0;
        }
        if (revString.length() == 10 && revString.charAt(0) >= '3') {
            return 0;
        }
        try {
            return Integer.valueOf(revString);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(1534236469));
    }
}

package count_and_say;

public class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String from = countAndSay(n - 1);

        int pointer = 0;
        char prev = from.charAt(0);
        int counter = 1;
        StringBuilder buffer = new StringBuilder();
        while (pointer < from.length()) {
            prev = from.charAt(pointer++);
            counter = 1;
            while (pointer < from.length() &&  from.charAt(pointer) == prev) {
                pointer++;
                counter++;
            }
            buffer.append(counter);
            buffer.append(prev);
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countAndSay(4));
    }
}

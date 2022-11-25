package strobogrammatic_number_3;

public class Solution2 {

    char[][] pairs = new char[][]{
            {'0', '0'}, {'1', '1'}, {'8', '8'}, {'6', '9'}, {'9', '6'}
    };
    char[] singles = new char[]{'0', '1', '8'};

    private int dfs(char[] buffer, int start, int end, String low, String high) {
        if (start > end) {
            if ((buffer.length == low.length() && new String(buffer).compareTo(low) < 0) || (buffer.length == high.length() && new String(buffer).compareTo(high) > 0)) {
                return 0;
            }
            return 1;
        }
        int counter = 0;
        if (start == end) {
            for (char s : singles) {
                buffer[start] = s;
                counter += dfs(buffer, start + 1, end - 1, low, high);
            }
        } else {
            for (char[] pair : pairs) {
                if (pair[0] != '0' || start != 0) {
                    buffer[start] = pair[0];
                    buffer[end] = pair[1];
                    counter += dfs(buffer, start + 1, end - 1, low, high);
                }
            }
        }
        return counter;
    }

    public int strobogrammaticInRange(String low, String high) {
        int counter = 0;
        for (int l = low.length(); l <= high.length(); l++) {
            char[] buffer = new char[l];
            counter += dfs(buffer, 0, l - 1, low, high);
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().strobogrammaticInRange("50","100"));
        System.out.println(new Solution2().strobogrammaticInRange("0", "0"));
        System.out.println(new Solution2().strobogrammaticInRange("1", "1"));
        System.out.println(new Solution2().strobogrammaticInRange("0", "1680"));
    }
}

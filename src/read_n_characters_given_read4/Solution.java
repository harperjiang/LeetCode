package read_n_characters_given_read4;

public class Solution {

    char[] buf4 = new char[4];
    int pointer = 0;
    int length = 0;

    public int read(char[] buf, int n) {
        int bufp = 0;
        if (length > 0) {
            int copylen = Math.min(n, length);
            System.arraycopy(buf4, pointer, buf, 0, copylen);
            pointer += copylen;
            length -= copylen;
            if (length == 0) {
                pointer = 0;
            }
            n -= copylen;
            bufp += copylen;
        }
        if (n > 0) {
            int loop = n / 4;
            int remain = n % 4;
            for (int i = 0; i < loop; i++) {
                int read = read4(buf4);
                System.arraycopy(buf4, 0, buf, bufp, read);
                bufp += read;
                if (read != 4) {
                    return bufp;
                }
            }
            int lastread = read4(buf4);
            if (lastread <= remain) {
                System.arraycopy(buf4, 0, buf, bufp, lastread);
                bufp += lastread;
                return bufp;
            } else {
                System.arraycopy(buf4, 0, buf, bufp, remain);
                pointer = remain;
                length = lastread - remain;
                return bufp + remain;
            }
        }
        return bufp;
    }

    int counter = 0;

    int read4(char[] buf) {
        counter++;
        if (counter == 1) {
            System.arraycopy(new char[]{'1', '2', '3', '4'}, 0, buf, 0, 4);
            return 4;
        } else if (counter == 2) {
            System.arraycopy(new char[]{'5', '6', '7', '0'}, 0, buf, 0, 4);
            return 3;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        char[] buf = new char[8];
        Solution solution = new Solution();
        System.out.println(solution.read(buf, 8));
    }
}

package utf8_validation;

public class Solution {

    int next(int[] data, int start) {
        if ((data[start] & 0x80) == 0) {
            return 1;
        }
        if ((data[start] & 0xE0) == 0xC0 && start + 1 < data.length && (data[start + 1] & 0xC0) == 0x80) {
            return 2;
        }
        if ((data[start] & 0xF0) == 0xE0 && start + 2 < data.length && (data[start + 1] & 0xC0) == 0x80 && (data[start + 2] & 0xC0) == 0x80) {
            return 3;
        }
        if ((data[start] & 0xF8) == 0xF0 && start + 3 < data.length && (data[start + 1] & 0xC0) == 0x80 && (data[start + 2] & 0xC0) == 0x80 && (data[start + 3] & 0xC0) == 0x80) {
            return 4;
        }
        return -1;
    }

    public boolean validUtf8(int[] data) {
        int pointer = 0;
        while (pointer < data.length) {
            int offset = next(data, pointer);
            if (offset <= 0) {
                return false;
            }
            pointer += offset;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().validUtf8(new int[]{115, 100, 102, 231, 154, 132, 13, 10}));
    }
}

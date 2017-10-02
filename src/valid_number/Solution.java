package valid_number;

/**
 * Created by harper on 10/1/17.
 */
public class Solution {

    public boolean isNumber(String s) {
        // Use the idea of tracking a reg exp
        // Reg exp for a number is -?d+(.d+)?(ed+)?
        //
        String trimmed = s.trim();

        int state = 0;

        int pointer = 0;
        char[] array = trimmed.toCharArray();
        while (pointer < array.length) {
            char c = array[pointer];
            switch (state) {
                case 0: // ^
                    if (c == '-' || c == '+') {
                        state = 1;
                        break;
                    }
                    if (Character.isDigit(c)) {
                        state = 2;
                        break;
                    }
                    if (c == '.') {
                        state = 3;
                        break;
                    }
                    return false;
                case 1: // ^-
                    if (Character.isDigit(c)) {
                        state = 4;
                        break;
                    }
                    if (c == '.') {
                        state = 5;
                        break;
                    }
                    return false;
                case 2: // ^d
                    if (Character.isDigit(c)) {
                        break;
                    }
                    if (c == '.') {
                        state = 6;
                        break;
                    }
                    if (c == 'e') {
                        state = 7;
                        break;
                    }
                    return false;
                case 3: // ^.
                    if (Character.isDigit(c)) {
                        state = 8;
                        break;
                    }
                    return false;
                case 4: // ^-d
                    if (Character.isDigit(c)) {
                        break;
                    }
                    if (c == '.') {
                        state = 6;
                        break;
                    }
                    if (c == 'e') {
                        state = 7;
                        break;
                    }
                    return false;
                case 5: // ^-.:
                    if (Character.isDigit(c)) {
                        state = 8;
                        break;
                    }
                    return false;
                case 6: // ^d.
                    if (Character.isDigit(c)) {
                        state = 12;
                        break;
                    }
                    if (c == 'e') {
                        state = 7;
                        break;
                    }
                    return false;
                case 7: // ^de ^d.e ^-de:
                    if (Character.isDigit(c)) {
                        state = 14;
                        break;
                    }
                    if (c == '-' || c == '+') {
                        state = 15;
                        break;
                    }
                    return false;
                case 8: // ^.d
                    if (Character.isDigit(c)) {
                        break;
                    }
                    if (c == 'e') {
                        state = 7;
                        break;
                    }
                    return false;
                case 12: // ^d.d
                    if (Character.isDigit(c)) {
                        break;
                    }
                    if (c == 'e') {
                        state = 7;
                        break;
                    }
                    return false;
                case 14: // ^ded
                    if (Character.isDigit(c)) {
                        break;
                    }
                    return false;
                case 15: // ^xxe+
                    if (Character.isDigit(c)) {
                        state = 14;
                        break;
                    }
                    return false;
                default:
                    return false;
            }
            pointer++;
        }
        return state == 14 || state == 2 || state == 4 || state == 6 || state == 8 || state == 12;
    }
}

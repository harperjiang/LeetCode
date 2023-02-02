package decode_string;

import java.util.Stack;

public class Solution {

    public String decodeString(String s) {
        StringBuilder buffer = new StringBuilder();
        int sum = 0;
        Stack<Object> stack;
        stack = new Stack<Object>();
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '[':
                    stack.push(sum);
                    sum = 0;
                    break;
                case ']':
                    while (!(stack.peek() instanceof Integer)) {
                        StringBuilder temp = (StringBuilder) stack.pop();
                        temp.append(buffer);
                        buffer = temp;
                    }
                    int repeat = (int) stack.pop();
                    String current = buffer.toString();
                    for (int i = 1; i < repeat; i++) {
                        buffer.append(current);
                    }
                    stack.push(buffer);
                    buffer = new StringBuilder();
                    break;
                default:
                    if (Character.isDigit(c)) {
                        if (buffer.length() > 0) {
                            stack.push(buffer);
                            buffer = new StringBuilder();
                        }
                        sum = sum * 10 + c - '0';
                    } else {
                        buffer.append((char) c);
                    }
                    break;
            }
        }
        if (buffer.length() > 0) {
            stack.push(buffer.toString());
        }
        for (Object item : stack) {
            result.append(item);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().decodeString("3[a]2[bc]"));
        System.out.println(new Solution().decodeString("3[a2[c]]"));
        System.out.println(new Solution().decodeString("2[abc]3[cd]ef"));
    }
}

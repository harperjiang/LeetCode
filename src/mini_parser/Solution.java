package mini_parser;

import java.util.Stack;

public class Solution {

    Integer sum = null;
    boolean pos = true;
    Stack<NestedInteger> stack = new Stack<>();

    protected void addInteger() {
        if (sum != null) {
            NestedInteger nni = new NestedInteger(pos ? sum : -sum);
            if (stack.isEmpty()) {
                stack.push(nni);
            } else {
                stack.peek().add(nni);
            }
            sum = null;
            pos = true;
        }
    }

    public NestedInteger deserialize(String s) {
        for (char c : s.toCharArray()) {
            switch (c) {
                case '[':
                    NestedInteger ni = new NestedInteger();
                    if (!stack.isEmpty()) {
                        stack.peek().add(ni);
                    }
                    stack.push(ni);
                    break;
                case ']':
                    addInteger();
                    if (stack.size() > 1) {
                        stack.pop();
                    }
                    sum = null;
                    pos = true;
                    break;
                case ',':
                    addInteger();
                    break;
                case '-':
                    pos = false;
                    sum = 0;
                    break;
                default:
                    if (sum == null) {
                        sum = 0;
                    }
                    sum = sum * 10 + c - '0';
                    break;
            }
        }
        addInteger();
        return stack.pop();
    }
}

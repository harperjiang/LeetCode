package basic_calculator_2;

import java.util.Map;
import java.util.Stack;

public class Solution {

    Map<Character, Integer> priority = Map.of('+', 0, '-', 0, '*', 1, '/', 1);

    protected int eval(Integer b, Integer a, char o) {
        switch (o) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                throw new IllegalArgumentException();
        }
    }

    public int calculate(String s) {
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

        Integer buffer = null;

        for (char c : s.toCharArray()) {
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                if (buffer != null) {
                    operands.push(buffer);
                    buffer = null;
                }
                int p = priority.get(c);
                while (!operators.isEmpty() && priority.get(operators.peek()) >= p) {
                    operands.push(eval(operands.pop(), operands.pop(), operators.pop()));
                }
                operators.push(c);
            } else if (Character.isDigit(c)) {
                if (buffer == null) {
                    buffer = (c - '0');
                } else {
                    buffer *= 10;
                    buffer += c - '0';
                }
            }
        }
        if (buffer != null) {
            operands.push(buffer);
        }
        while (!operators.isEmpty()) {
            operands.push(eval(operands.pop(), operands.pop(), operators.pop()));
        }
        return operands.peek();
    }

    public static void main(String[] args) {
        new Solution().calculate("1+1+1");
    }
}

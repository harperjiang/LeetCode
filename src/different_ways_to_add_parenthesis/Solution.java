package different_ways_to_add_parenthesis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    protected List<Integer> eval(int from, int to) {
        int index = (from << 16) | to;
        if (buffers.containsKey(index)) {
            return buffers.get(index);
        }

        List<Integer> result = new ArrayList<>();
        if (from == to - 1) {
            result.add((Integer) tokens.get(from));
        } else {
            for (int i = from; i < to; i++) {
                if (tokens.get(i) instanceof Character) { // an operator
                    List<Integer> left = eval(from, i);
                    List<Integer> right = eval(i + 1, to);
                    char opr = (Character) tokens.get(i);
                    for(Integer l:left) {
                        for(Integer r:right) {
                            switch (opr) {
                                case '+':
                                    result.add(l+r);
                                    break;
                                case '-':
                                    result.add(l-r);
                                    break;
                                case '*':
                                    result.add(l*r);
                                    break;
                            }
                        }
                    }
                }
            }
        }

        buffers.put(index, result);
        return result;
    }

    List<Object> tokens = new ArrayList<>();
    Map<Integer, List<Integer>> buffers = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        tokens.clear();
        int numbuffer = 0;
        for (int i = 0; i < expression.length(); ++i) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                tokens.add(numbuffer);
                numbuffer = 0;
                tokens.add(c);
            } else {
                numbuffer *= 10;
                numbuffer += (c - '0');
            }
        }
        tokens.add(numbuffer);
        buffers.clear();
        return eval(0, tokens.size());
    }
}

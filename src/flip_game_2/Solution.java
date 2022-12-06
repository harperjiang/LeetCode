package flip_game_2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    boolean aturn(char[] schar, Map<String, Boolean> visited) {
        String state = new String(schar);
        if (visited.containsKey(state)) {
            return visited.get(state);
        }
        for (int i = 1; i < schar.length; i++) {
            if (schar[i] == '+' && schar[i] == schar[i - 1]) {
                schar[i - 1] = '-';
                schar[i] = '-';
                boolean win = bturn(schar, visited);
                schar[i - 1] = '+';
                schar[i] = '+';
                if (win) {
                    visited.put(state, true);
                    return true;
                }
            }
        }
        visited.put(state, false);
        return false;
    }

    boolean bturn(char[] schar, Map<String, Boolean> visited) {
        String state = new String(schar);
        if (visited.containsKey(state)) {
            return visited.get(state);
        }
        boolean win = true;
        for (int i = 1; i < schar.length; i++) {
            if (schar[i] == '+' && schar[i] == schar[i - 1]) {
                schar[i - 1] = '-';
                schar[i] = '-';
                win &= aturn(schar, visited);
                schar[i - 1] = '+';
                schar[i] = '+';
                if (!win) {
                    break;
                }
            }
        }
        visited.put(state.toString(), win);
        return win;
    }

    public boolean canWin(String currentState) {
        Map<String, Boolean> visitedStates = new HashMap<>();
        return aturn(currentState.toCharArray(), visitedStates);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canWin("--"));
    }
}

package generalized_abbreviation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    void dfs(List<String> result, List<Object> buffer, String word, int index) {
        if (index == word.length()) {
            StringBuilder builder = new StringBuilder();
            for(Object o : buffer) {
                builder.append(String.valueOf(o));
            }
            result.add(builder.toString());
            return;
        }
        char nextc = word.charAt(index);
        if (buffer.isEmpty()) {
            buffer.add(1);
            dfs(result, buffer, word, 1);
            buffer.remove(0);
            buffer.add(nextc);
            dfs(result, buffer, word, 1);
        } else {
            Object last = buffer.get(buffer.size() - 1);
            if (last instanceof Integer) {
                buffer.set(buffer.size() - 1, ((int) last) + 1);
                dfs(result, buffer, word, index + 1);
                buffer.set(buffer.size() - 1, last);
                buffer.add(nextc);
                dfs(result, buffer, word, index + 1);
                buffer.remove(buffer.size()-1);
            } else {
                buffer.add(1);
                dfs(result, buffer, word, index + 1);
                buffer.remove(buffer.size() - 1);
                buffer.add(nextc);
                dfs(result, buffer, word, index + 1);
                buffer.remove(buffer.size()-1);
            }
        }
    }

    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        List<Object> buffer = new ArrayList<>();
        dfs(result, buffer, word, 0);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generateAbbreviations("word"));
    }
}

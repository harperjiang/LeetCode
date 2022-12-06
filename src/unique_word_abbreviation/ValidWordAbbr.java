package unique_word_abbreviation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidWordAbbr {

    Map<String, Set<String>> abbrs = new HashMap<>();

    String abbr(String word) {
        StringBuilder sb = new StringBuilder();
        sb.append(word.charAt(0)).append(word.length() - 2).append(word.charAt(word.length() - 1));
        return sb.toString();
    }

    public ValidWordAbbr(String[] dictionary) {
        abbrs.clear();
        for (String word : dictionary) {
            String abbr = abbr(word);
            abbrs.computeIfAbsent(abbr, key -> new HashSet<>()).add(word);
        }
    }

    public boolean isUnique(String word) {
        String abbr = abbr(word);
        Set<String> exist = abbrs.get(abbr);
        return exist == null || (exist.size() == 1 && exist.contains(word));
    }
}

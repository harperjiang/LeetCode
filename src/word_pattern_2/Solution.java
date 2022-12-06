package word_pattern_2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    boolean search(Map<Character, String> mapping, Set<String> mapped, String pattern, String content, int pp, int cp) {
        if (pp == pattern.length() && cp == content.length()) {
            return true;
        }
        if (pp == pattern.length() || cp == content.length()) {
            return false;
        }
        char np = pattern.charAt(pp);
        if (mapping.containsKey(np)) {
            String exist = mapping.get(np);
            if (content.length() < exist.length() + cp || !content.substring(cp).startsWith(exist)) {
                return false;
            } else {
                return search(mapping, mapped, pattern, content, pp + 1, cp + exist.length());
            }
        } else { // Try all possible mappings
            for (int i = 1; cp + i <= content.length(); i++) {
                String cand = content.substring(cp, cp + i);
                if (mapped.contains(cand)) {
                    continue;
                }
                mapping.put(np, cand);
                mapped.add(cand);
                if (search(mapping, mapped, pattern, content, pp, cp)) {
                    return true;
                }
                mapped.remove(cand);
                mapping.remove(np);
            }
            return false;
        }
    }

    public boolean wordPatternMatch(String pattern, String s) {
        Map<Character, String> mapping = new HashMap<>();
        Set<String> mapped = new HashSet<>();
        return search(mapping, mapped, pattern, s, 0, 0);
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().wordPatternMatch("abab","redblueredblue"));
//        System.out.println(new Solution().wordPatternMatch("aaaa","asdasdasdasd"));
//        System.out.println(new Solution().wordPatternMatch("aabb","xyzabcxzyabc"));
//        System.out.println(new Solution().wordPatternMatch("abab", "asdasdasdasd"));
//        System.out.println(new Solution().wordPatternMatch("d", "e"));
//        System.out.println(new Solution().wordPatternMatch("ab", "aa"));
        System.out.println(new Solution().wordPatternMatch("abba", "dogcatcatdog"));
    }
}

package shortest_word_distance_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDistance {

    Map<String, List<Integer>> pos = new HashMap<>();

    public WordDistance(String[] wordsDict) {
        for (int i = 0; i < wordsDict.length; i++) {
            final int index = i;
            pos.compute(wordsDict[i], (k, v) -> {
                if (v == null) {
                    List<Integer> p = new ArrayList<>();
                    p.add(index);
                    return p;
                } else {
                    v.add(index);
                    return v;
                }
            });
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> w1 = pos.get(word1);
        List<Integer> w2 = pos.get(word2);

        int min = Integer.MAX_VALUE;
        int p1 = 0, p2 = 0;
        int pos1 = w1.get(p1);
        int pos2 = w2.get(p2);
        while (p1 < w1.size() && p2 < w2.size()) {
            pos1 = w1.get(p1);
            pos2 = w2.get(p2);
            min = Math.min(min, Math.abs(pos1 - pos2));
            if (pos1 < pos2) {
                p1++;
            } else {
                p2++;
            }
        }
        if (p1 == w1.size()) {
            if (pos1 < pos2) {
                return min;
            } else {
                while (p2 < w2.size()) {
                    pos2 = w2.get(p2);
                    int dist = Math.abs(pos1 - pos2);
                    if (dist > min) {
                        break;
                    } else {
                        min = dist;
                    }
                }
                return min;
            }
        }
        if (p2 == w2.size()) {
            if (pos2 < pos1) {
                return min;
            } else {
                while (p1 < w1.size()) {
                    pos1 = w1.get(p1);
                    int dist = Math.abs(pos1 - pos2);
                    if (dist > min) {
                        break;
                    } else {
                        min = dist;
                    }
                }
                return min;
            }
        }
        return -1;
    }
}

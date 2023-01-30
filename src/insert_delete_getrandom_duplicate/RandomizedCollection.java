package insert_delete_getrandom_duplicate;

import java.util.*;

public class RandomizedCollection {

    Map<Integer, Integer> counters;

    Map<Integer, Set<Integer>> index;

    List<Integer> values;

    public RandomizedCollection() {
        counters = new HashMap<>();
        index = new HashMap<>();
        values = new ArrayList<>();
    }

    public boolean insert(int val) {
        counters.put(val, counters.getOrDefault(val, 0) + 1);
        index.computeIfAbsent(val, i -> new HashSet<>()).add(values.size());
        values.add(val);
        return counters.get(val) == 1;
    }

    public boolean remove(int val) {
        if (counters.getOrDefault(val, 0) > 0) {
            counters.put(val, counters.get(val) - 1);
            int replace = values.get(values.size() - 1);
            if (replace == val) {
                index.get(val).remove(values.size() - 1);
            } else {
                int targetidx = index.get(val).iterator().next();
                index.get(replace).remove(values.size() - 1);
                values.set(targetidx, replace);
                index.get(replace).add(targetidx);
                index.get(val).remove(targetidx);
            }
            values.remove(values.size() - 1);
            return true;
        }
        return false;
    }

    Random r = new Random(System.currentTimeMillis());

    public int getRandom() {
        return values.get(r.nextInt(values.size()));
    }
}

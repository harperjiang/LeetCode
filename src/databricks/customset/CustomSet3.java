package databricks.customset;

import java.util.*;

public class CustomSet3 {

    Set<Integer> storage = new HashSet<>();
    Map<Integer, Integer> logs = new HashMap<>();

    public boolean add(int i) {
        if (!storage.contains(i)) {
            logs.put(i, 0);
        }
        return true;
    }

    public boolean remove(int i) {
        if (storage.contains(i) || logs.containsKey(i)) {
            logs.put(i, 1);
            return true;
        }
        return false;
    }

    public boolean contains(int i) {
        if (logs.getOrDefault(i, 1) == 0) {
            // In logs
            return true;
        }
        if (storage.contains(i) && logs.getOrDefault(i, 0) != 1) {
            return true;
        }
        return false;
    }

    public Iterator<Integer> iterator() {
        for (Map.Entry<Integer,Integer> e: logs.entrySet()) {
            if(e.getValue()== 0) {
                storage.add(e.getKey());
            } else {
                storage.remove(e.getKey());
            }
        }
        logs.clear();
        return storage.iterator();
    }

    public void printAll() {
        for (int num : storage) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        CustomSet3 cs2 = new CustomSet3();

        cs2.add(1);
        cs2.add(2);
        System.out.println(cs2.contains(1));
        cs2.iterator();

        cs2.remove(1);
        System.out.println(cs2.contains(1));

        cs2.printAll();
        cs2.iterator();
        cs2.printAll();
    }
}
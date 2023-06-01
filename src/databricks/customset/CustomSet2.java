package databricks.customset;

import java.util.*;

public class CustomSet2 {

    Map<Integer, TreeSet<int[]>> versionStorage = new HashMap<>();

    int version = 0;

    static int FLAG_ADD = 0;
    static int FLAG_DEL = 1;

    public boolean add(int i) {
        TreeSet<int[]> entry = versionStorage.computeIfAbsent(i, (Integer key) ->
                new TreeSet<>(Comparator.comparing((int[] val) -> val[0])));
        if (entry.isEmpty()) {
            entry.add(new int[]{version, FLAG_ADD});
        } else {
            int[] last = entry.last();
            if (last[1] == FLAG_DEL && last[0] == version) {
                entry.remove(last);
            }
        }
        return true;
    }

    public boolean remove(int i) {
        if (versionStorage.containsKey(i)) {
            TreeSet<int[]> versions = versionStorage.get(i);

            int[] last = versions.last();
            if (last[1] == FLAG_ADD && last[0] == version) {
                versions.remove(last);
            } else {
                versions.add(new int[]{version, FLAG_DEL});
            }
            return true;
        }
        return false;
    }

    public boolean contains(int i) {
        if (versionStorage.containsKey(i)) {
            TreeSet<int[]> versions = versionStorage.get(i);
            return versions.last()[1] == FLAG_ADD;
        }
        return false;
    }

    Iterator<Integer> iterator;

    public Iterator<Integer> iterator() {
        this.iterator = new VersionIterator(version);
        version++;
        return this.iterator;
    }

    public void printAll() {
        while (this.iterator.hasNext()) {
            System.out.println(this.iterator.next());
        }
    }

    class VersionIterator implements Iterator<Integer> {

        int v;
        Iterator<Map.Entry<Integer, TreeSet<int[]>>> internal;

        Map.Entry<Integer, TreeSet<int[]>> next = null;

        void loadNext() {
            if (next != null) {
                return;
            }
            if (internal == null) {
                this.internal = versionStorage.entrySet().iterator();
            }
            if (internal.hasNext()) {
                while (internal.hasNext()) {
                    next = internal.next();
                    TreeSet<int[]> versions = next.getValue();
                    int[] entry = versions.floor(new int[]{v, 0});
                    if (entry != null && entry[1] == FLAG_ADD) {
                        return;
                    }
                }
            }
            next = null;
        }

        VersionIterator(int version) {
            this.v = version;
        }

        @Override
        public boolean hasNext() {
            loadNext();
            return next != null;
        }

        @Override
        public Integer next() {
            int value = next.getKey();
            next = null;
            loadNext();
            return value;
        }
    }

    public static void main(String[] args) {
        CustomSet2 cs2 = new CustomSet2();

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
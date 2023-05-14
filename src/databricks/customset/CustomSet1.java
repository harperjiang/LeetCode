package databricks.customset;

import java.util.*;

public class CustomSet1 {

    Set<Integer> container = new HashSet<>();

    public boolean add(int i) {
        return container.add(i);
    }

    public boolean remove(int i) {
        return container.remove(i);
    }

    public boolean contains(int i) {
        return container.contains(i);
    }

    public Iterator<Integer> iterator() {
        Set<Integer> copy = new HashSet<>(container);
        return copy.iterator();
    }

    public void printAll() {
        //print all elements using the iterator
    }
}
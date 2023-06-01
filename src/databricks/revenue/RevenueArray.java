package databricks.revenue;

import javax.print.event.PrintEvent;
import java.util.*;

public class RevenueArray {

    TreeSet<int[]> storage = new TreeSet<>(Comparator.comparing((int[] x) -> x[1]));
    Map<Integer, Integer> revenues = new HashMap<>();
    List<List<Integer>> referrers = new ArrayList<>();

    Map<Integer, Integer> parent = new HashMap<>();
    List<List<Integer>> layerRevenues = new ArrayList<>();

    public int insert(int revenue) {/* Insert a new customer to the system, with the given revenue. Return the new customer ID */
        return insert(revenue, -1);
    }

    public int insert(int revenue, int referrer) {/*Insert a new customer to the system, with the given revenue, and revenue also added to the referrer. Return the new customer ID */
        int id = storage.size();
        storage.add(new int[]{id, revenue, referrer});
        revenues.put(id, revenue);
        referrers.add(new ArrayList<>());
        layerRevenues.add(new ArrayList<>());
        layerRevenues.get(id).add(revenue);
        if (referrer != -1) {
            referrers.get(referrer).add(id);
            parent.put(id, referrer);
            updateLayer(revenue, referrer, 1);
        }
        return id;
    }

    void updateLayer(int revenue, int customer, int level) {
        List<Integer> layerRev = layerRevenues.get(customer);
        if (layerRev.size() <= level) {
            layerRev.add(revenue);
        } else {
            layerRev.set(level, layerRev.get(level) + revenue);
        }
        if (parent.containsKey(customer)) {
            updateLayer(revenue, parent.get(customer), level + 1);
        }
    }

    List<Integer> get_lowest_k_by_total_revenue(int k, int min_total_revenue) {
        int[] target = new int[]{-1, min_total_revenue};
        Iterator<int[]> greater = storage.tailSet(target, true).iterator();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (!greater.hasNext()) {
                break;
            }
            result.add(greater.next()[0]);
        }
        return result;
    }

    public int getTotalRev(int customer, int depth) {
        int sum = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{customer, revenues.get(customer)});
        for (int i = 0; i <= depth; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int[] entry = queue.poll();
                sum += entry[1];
                for (int child : referrers.get(entry[0])) {
                    queue.add(new int[]{child, revenues.get(child)});
                }
            }
        }
        return sum;
    }

    public int getTotalRev2(int customer, int depth) {
        List<Integer> layerRev = layerRevenues.get(customer);
        int max = Math.min(depth + 1, layerRev.size());
        int sum = 0;
        for (int i = 0; i < max; i++) {
            sum += layerRev.get(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        RevenueArray rev = new RevenueArray();
        rev.insert(80);
        rev.insert(50, 0);
        rev.insert(70, 0);
        rev.insert(130, 1);
        rev.insert(120, 2);
        rev.insert(20);

        System.out.println(rev.getTotalRev(0, 0));
        System.out.println(rev.getTotalRev(0, 1));
        System.out.println(rev.getTotalRev(0, 2));
        System.out.println(rev.getTotalRev(0, 3));

        System.out.println(rev.getTotalRev2(0, 0));
        System.out.println(rev.getTotalRev2(0, 1));
        System.out.println(rev.getTotalRev2(0, 2));
        System.out.println(rev.getTotalRev2(0, 3));
    }
}

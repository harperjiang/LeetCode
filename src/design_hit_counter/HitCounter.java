package design_hit_counter;

import java.util.Arrays;

public class HitCounter {

    int[] counters = new int[300];
    int base = 0;

    int counter = 0;

    public HitCounter() {

    }

    public void hit(int timestamp) {
        if (timestamp - base >= 600) {
            Arrays.fill(counters, 0);
            counter = 0;
            base = timestamp;
        } else {
        while (timestamp - base >= 300) {
            counter -= counters[base % 300];
            counters[base % 300] = 0;
            base++;
        }
        }
        counters[timestamp % 300]++;
        counter++;
    }

    public int getHits(int timestamp) {
        if (timestamp - base >= 600) {
            Arrays.fill(counters, 0);
            counter = 0;
            base = timestamp;
        } else {
        while (timestamp - base >= 300) {
            counter -= counters[base % 300];
            counters[base % 300] = 0;
            base++;
        }
        }
        return counter;
    }

    public static void main(String[] args) {
        HitCounter hc = new HitCounter();
//        hit","hit","hit","hit","hit","hit","getHits","hit","getHits","hit","getHits"
//        100],[282],[411],[609],[620],[744],[879],     [956],[976],[998],[1055
        hc.hit(100);
        hc.hit(282);
        hc.hit(411);
        hc.hit(609);
        hc.hit(620);
        hc.hit(744);
        System.out.println(hc.getHits(879));
        hc.hit(956);
        System.out.println(hc.getHits(976));
        hc.hit(998);
        System.out.println(hc.getHits(1055));
    }
}

package databricks.map_with_call_freq;

import java.util.Arrays;

public class HitCounter {

    int total;
    int buffer[] = new int[300];
    long base;

    void updateTimestamp(long ts) {
        if (ts - base >= 300) {
            long newbase = ts - 299;
            if (newbase - base >= 300) {
                total = 0;
                Arrays.fill(buffer, 0);
            } else {
                for (long i = base; i < newbase; i++) {
                    total -= buffer[(int)(i % 300)];
                    buffer[(int)(i % 300)] = 0;
                }
            }
            base = newbase;
        }
    }

    void hit(long timestamp) {
        updateTimestamp(timestamp);
        buffer[(int)(timestamp % 300)]++;
        total++;
    }

    int getHit(long timestamp) {
        updateTimestamp(timestamp);
        return total;
    }
}

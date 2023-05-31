package databricks.lt751;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    long ip2num(String ip) {
        String[] pieces = ip.split("\\.");
        return (Long.valueOf(pieces[0]) << 24) +
                (Long.valueOf(pieces[1]) << 16) +
                (Long.valueOf(pieces[2]) << 8) +
                (Long.valueOf(pieces[3]));
    }

    public List<String> ipToCIDR(String ip, int n) {
        long start = ip2num(ip);
        long end = start + n;

        int level = 0;

        List<long[]> result = new ArrayList<>();
        while (start < end) {
            if (start % 2 == 1) {
                result.add(new long[]{start, level});
                start <<= 1;
                start -= 1;
            } else {
                start <<= 1;
            }

            if (end % 2 == 0) {
                result.add(new long[]{end, level});
                end <<= 1;
                end -= 1;
            } else {
                end <<= 1;
            }
            level++;
            if (start == end) {
                result.add(new long[]{start, level});
                break;
            }
        }
        return null;
    }
}

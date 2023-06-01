package maximum_donuts;

import java.util.*;

public class Solution {

    Map<Long, Integer> dpbuffer = new HashMap<>();
    int batchSize;

    Long encode(int[] freq) {
        Long base = 0L;
        for (int i = freq.length - 1; i >= 0; i--) {
            base <<= 5;
            base += freq[i];
        }
        return base;
    }

    Long decrease(Long state, int index) {
        Long piece = (state >> (index * 5)) & 0x1F;
        if (piece > 0) {
            return state - (1L << index * 5);
        }
        return state;
    }

    int dfs(Long state, int rem) {
        if (dpbuffer.containsKey(state)) {
            return dpbuffer.get(state);
        }
        if (state == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < batchSize; i++) {
            long prevstate = decrease(state, i);
            if (prevstate == state) {
                continue;
            }
            max = Math.max(max, dfs(prevstate, (rem + i) % batchSize));
        }
        if (rem == 0) {
            max += 1;
        }
        dpbuffer.put(state, max);
        return max;
    }

    public int maxHappyGroups(int batchSize, int[] groups) {
        this.batchSize = batchSize;
        int[] freq = new int[batchSize];
        for (int group : groups) {
            freq[group % batchSize]++;
        }
        int done = freq[0];
        freq[0] = 0;
        for (int i = 1; i < batchSize / 2; i++) {
            int rem = Math.min(freq[i], freq[batchSize - i]);
            done += rem;
            freq[i] -= rem;
            freq[batchSize - i] -= rem;
        }
        Long state = encode(freq);

        return dfs(state, 0) + done;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().maxHappyGroups(3, new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(new Solution().maxHappyGroups(4, new int[]{1, 3, 2, 5, 2, 2, 1, 6}));
//        System.out.println(new Solution().maxHappyGroups(2, new int[]{652231582, 818492002, 823729239,
//                2261354, 747144855, 478230860, 285970257, 774747712,
//                860954510, 245631565, 634746161, 109765576, 967900367,
//                340837477, 32845752, 23968185}));
//        System.out.println(new Solution().maxHappyGroups(9, new int[]{1, 8, 1, 8, 1, 8, 1, 8, 2, 7, 2, 7, 2, 7, 2, 7, 3, 6, 3, 6, 3, 6, 3, 6, 4, 5, 4, 5, 4, 5}));
    }
}

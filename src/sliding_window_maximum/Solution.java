package sliding_window_maximum;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] counter = new int[20002];
        int offset = 5;
        int[] result = new int[nums.length + 1 - k];
        int max = -10001;
        for (int i = 0; i < k; ++i) {
            int num = nums[i];
            counter[num + offset]++;
            max = Math.max(max, num);
        }
        result[0] = max;
        for (int i = 0; i < result.length - 1; ++i) {
            int remove = nums[i];
            int add = nums[k + i];
            counter[remove + offset]--;
            counter[add + offset]++;
            if (add > max) {
                max = add;
            } else if (remove == max && counter[remove + offset] == 0) {
                int p = max + offset;
                while (counter[p] == 0) p--;
                max = p - offset;
            }
            result[i + 1] = max;
        }
        return result;
    }

    public static void main(String[] args) {
        new Solution().maxSlidingWindow(new int[]{1, -1}, 1);
    }
}

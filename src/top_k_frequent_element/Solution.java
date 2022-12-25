package top_k_frequent_element;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        Arrays.sort(nums);
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing((int[] i) -> i[1]));
        int prev = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                int newk = i - prev;
                prev = i;
                queue.add(new int[]{nums[i - 1], newk});
                while (queue.size() > k) queue.poll();
            }
        }
        queue.add(new int[]{nums[nums.length - 1], nums.length - prev});
        while (queue.size() > k) queue.poll();
        int[] result = new int[k];
        int c = 0;
        while (!queue.isEmpty()) {
            result[c++] = queue.poll()[0];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().topKFrequent(new int[]{1,1,1,2,2,3},2));
    }
}

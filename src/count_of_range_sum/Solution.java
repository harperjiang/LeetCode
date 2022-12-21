package count_of_range_sum;

import java.text.MessageFormat;

public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] cumsum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            cumsum[i + 1] = cumsum[i] + nums[i];
        }
        // Now we need to look for all pairs of cumsum[j+1] - cumsum[i] between lower and upper, where j+1>i
        // If we do not sort the cumsum, then there will be O(n^2) pairs to compares
        // But if we sort the whole array, we cannot guarantee the j+1 > i condition
        // The solution is to split the array, sort the lower part and the upper part separately
        // Now all elements in the lower part have index less than the upper part, and each separate parts is sorted

        long[] buffer = new long[cumsum.length];
        return countMergeSort(cumsum, buffer, 0, nums.length + 1, lower, upper);
    }

    int countMergeSort(long[] cumsum, long[] buffer, int start, int end, int lower, int upper) {
//        System.out.println(MessageFormat.format("{0},{1}", start, end));
        if (start >= end || start == end - 1) {
            return 0;
        }
        int middle = (start + end) / 2;

        int count = countMergeSort(cumsum, buffer, start, middle, lower, upper)
                + countMergeSort(cumsum, buffer, middle, end, lower, upper);
        int lp = middle;
        int up = middle;
        for (int i = start; i < middle; i++) {
            while (lp < end && cumsum[lp] - cumsum[i] < lower) lp++;
            while (up < end && cumsum[up] - cumsum[i] <= upper) up++;
            count += up - lp;
        }
        merge(cumsum, buffer, start, middle, end);
//        System.out.println(MessageFormat.format("{0},{1}:{2}", start, end, count));
        return count;
    }

    void merge(long[] cumsum, long[] helper, int start, int middle, int end) {
        int fp = start;
        int sp = middle;
        int hp = start;

        while (fp < middle && sp < end) {
            if (cumsum[fp] <= cumsum[sp]) {
                helper[hp++] = cumsum[fp++];
            } else {
                helper[hp++] = cumsum[sp++];
            }
        }
        while (fp < middle) helper[hp++] = cumsum[fp++];
        while (sp < end) helper[hp++] = cumsum[sp++];
        System.arraycopy(helper, start, cumsum, start, end - start);
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().countRangeSum(new int[]{-2, 5, -1}, -2, 2));
//        System.out.println(new Solution().countRangeSum(new int[]{0}, 0, 0));
//        System.out.println(new Solution().countRangeSum(new int[]{0, 0}, 0, 0));
//        System.out.println(new Solution().countRangeSum(new int[]{2147483647, -2147483648, -1, 0}, -1, 0));
        System.out.println(new Solution().countRangeSum(new int[]{-2147483647, 0, -2147483647, 2147483647}, -564, 3864));
    }
}

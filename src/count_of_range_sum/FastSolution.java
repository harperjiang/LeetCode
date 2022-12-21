package count_of_range_sum;

public class FastSolution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] prefix = new long[nums.length + 1];
        for(int i = 1; i <= nums.length; i++) prefix[i] = prefix[i-1] + nums[i-1];
        return countingMergeSort(prefix, new long[prefix.length], 0, prefix.length - 1, lower, upper);
    }

    private int countingMergeSort(long[] prefix, long[] helper, int low, int high, long lower, long upper) {
        if (low >= high)
            return 0;

        int mid = (high + 1 - low) / 2 + low; // start of right part
        int count = countingMergeSort(prefix, helper, low, mid - 1, lower, upper)
                + countingMergeSort(prefix, helper, mid, high, lower, upper);

        int rangeStart = mid, rangeEnd = mid;  // start inclusive, end exclusive
        for(int i = low; i < mid; i++) {
            while(rangeStart <= high && prefix[rangeStart] - prefix[i] < lower)
                rangeStart++;
            while(rangeEnd <= high && prefix[rangeEnd] - prefix[i] <= upper)
                rangeEnd++;

            count += rangeEnd - rangeStart;
        }

        merge(prefix, helper, low, mid, high);
        return count;
    }

    private void merge(long[] prefix, long[] helper, int low, int mid, int high) {
        int left = low, right = mid, idx = low;

        while(left < mid && right <= high) {
            if (prefix[left] <= prefix[right])
                helper[idx++] = prefix[left++];
            else
                helper[idx++] = prefix[right++];
        }

        while(left < mid)
            helper[idx++] = prefix[left++];
        while(right <= high)
            helper[idx++] = prefix[right++];

        System.arraycopy(helper, low, prefix, low, high + 1 - low);
    }
}

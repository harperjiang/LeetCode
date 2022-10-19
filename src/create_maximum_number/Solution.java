package create_maximum_number;

import java.util.Arrays;

/**
 * @author harper
 */
public class Solution {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int from = Integer.max(k - nums2.length, 0);
        int to = Integer.min(k, nums1.length);

        int[] current = null;
        for (int i = from; i <= to; i++) {
            int[] maxFromS1 = max(nums1, i);
            int[] maxFromS2 = max(nums2, k - i);
            int[] num = merge(maxFromS1, maxFromS2);
            if (compare(num, current, 0, 0) < 0)
                current = num;
        }
        return current;
    }

    protected int[] max(int[] nums, int k) {
//        if (limit == input.length)
//            return input;
//        int[] result = new int[limit];
//        if (limit == 0)
//            return result;
//        for (int i = 0; i < input.length; i++) {
//            int current = input[i];
//            int start = Integer.max(0, limit - input.length + i);
//
//            for (int j = start; j < limit; j++) {
//                if (current > result[j]) {
//                    result[j] = current;
//                    Arrays.fill(result, j + 1, limit, 0);
//                    break;
//                }
//            }
//        }
//        return result;

        int[] res = new int[k];
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            while (len > 0 && len + nums.length - i > k && res[len - 1] < nums[i]) {
                len--;
            }
            if (len < k)
                res[len++] = nums[i];
        }
        return res;
    }

    protected int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int ap = 0, bp = 0;
        for (int i = 0; i < result.length; i++) {
            if (ap == a.length) {
                result[i] = b[bp++];
            } else if (bp == b.length) {
                result[i] = a[ap++];
            } else {
                if (a[ap] > b[bp]) {
                    result[i] = a[ap++];
                } else if (a[ap] < b[bp]) {
                    result[i] = b[bp++];
                } else {
                    // Find next larger
                    int compare = compare(a, b, ap, bp);
                    if (compare >= 0)
                        result[i] = b[bp++];
                    else
                        result[i] = a[ap++];
                }
            }
        }

        return result;
    }

    protected int compare(int[] a, int[] b, int astart, int bstart) {
        if (a == null)
            return 1;
        if (b == null)
            return -1;
        int counter = 0;
        while (astart + counter < a.length && bstart + counter < b.length) {
            if (a[astart + counter] > b[bstart + counter])
                return -1;
            if (a[astart + counter] < b[bstart + counter])
                return 1;
            counter++;
        }
        if (astart + counter == a.length && bstart + counter == b.length)
            return 0;
        // whoever has remains win
        if (astart + counter == a.length)
            return 1;
        if (bstart + counter == b.length)
            return -1;
        return 0;
    }
}
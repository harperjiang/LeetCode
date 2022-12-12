package range_sum_query_mutable;

import java.text.MessageFormat;

public class NumArray2 {
    int[] tree;
    int n;

    public NumArray2(int[] nums) {
        n = nums.length;
        if (n % 2 == 0) {
            n++;
        }
        tree = new int[2 * n];
        System.arraycopy(nums, 0, tree, n, n);
        for (int i = n - 1; i >= 0; i--) {
            tree[i] = tree[2 * i] + tree[2 * i + 1];
        }
    }

    void update(int pos, int val) {
        int diff = val - tree[n + pos];
        int start = n + pos;
        while (start > 0) {
            tree[start] += diff;
            start /= 2;
        }
        tree[0] += diff;
    }

    public int sumRange(int l, int r) {
        int sum = 0;
        int lb = n + l;
        int ub = n + r;
        while (lb <= ub) {
            System.out.println(MessageFormat.format("{0},{1}", lb, ub));
            if (lb % 2 == 1) {
                sum += tree[lb];
                lb++;
            }
            if (ub % 2 == 0) {
                sum += tree[ub];
                ub--;
            }
            lb /= 2;
            ub /= 2;
        }
        sum += tree[lb];
        return sum;
    }

    public static void main(String[] args) {
        NumArray2 nm = new NumArray2(new int[]{1, 2, 4, 8, 16});
//        nm.update(4,6);
//        nm.update(0,2);
//        nm.update(0,9);
//        System.out.println(nm.sumRange(4,4));
//        nm.update(3,8);
        System.out.println(nm.sumRange(0, 4));
        nm.update(4, 1);
//        System.out.println(nm.sumRange(0,3));
//        System.out.println(nm.sumRange(0,4));
    }
}

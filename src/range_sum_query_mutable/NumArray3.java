package range_sum_query_mutable;

import java.text.MessageFormat;

public class NumArray3 {

    int[] nums;
    int[] tree;
    int n;

    public NumArray3(int[] nums) {
        this.nums = new int[nums.length];
        tree = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            update(i, nums[i]);
        }
    }

    void update(int pos, int val) {
        int diff = val - nums[pos];
        int pointer = pos + 1;
        while (pointer < tree.length) {
            tree[pointer] += diff;
            pointer += pointer & (-pointer);
        }
        nums[pos] = val;
    }

    int cumsum(int pos) {
        int sum = 0;
        int pointer = pos;
        while (pointer > 0) {
            sum += tree[pointer];
            pointer -= pointer & -pointer;
        }
        return sum;
    }

    public int sumRange(int l, int r) {
        return cumsum(r+1) - cumsum(l);
    }

    public static void main(String[] args) {
        NumArray3 nm = new NumArray3(new int[]{1, 3, 5});
        System.out.println(nm.sumRange(0, 2));
        nm.update(1, 2);
        System.out.println(nm.sumRange(0, 2));
    }
}

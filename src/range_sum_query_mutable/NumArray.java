package range_sum_query_mutable;

public class NumArray {

    int[] tree;
    int base = 0;

    public NumArray(int[] nums) {
        int size = nums.length;
        int counter = 0;
        while (size > 0) {
            size >>= 1;
            counter++;
        }
        this.tree = new int[(1 << (counter + 1)) - 1];
        base = (1 << counter) - 1;
        System.arraycopy(nums, 0, tree, base, nums.length);
        for (int i = base - 1; i >= 0; i--) {
            tree[i] = tree[i * 2 + 1] + tree[(i + 1) * 2];
        }
    }

    public void update(int index, int val) {
        int pointer = base + index;
        int diff = val - tree[pointer];
        tree[pointer] = val;
        pointer = (pointer - 1) / 2;
        while (pointer > 0) {
            tree[pointer] += diff;
            pointer = (pointer - 1) / 2;
        }
        tree[0] += diff;
    }

    public int sumRange(int left, int right) {
        int lb = base + left + 1;
        int ub = base + right + 1;
        int sum = 0;
        while (lb <= ub) {
            if (lb % 2 == 1) {
                sum += tree[lb - 1];
                lb++;
            }
            if (ub % 2 == 0) {
                sum += tree[ub - 1];
                ub--;
            }
            lb /= 2;
            ub /= 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        NumArray nm = new NumArray(new int[]{1, 3, 5});
        System.out.println(nm.sumRange(0, 2));
        nm.update(1, 2);
        System.out.println(nm.sumRange(0, 2));
    }
}

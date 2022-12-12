package range_sum_query_mutable;

public class NumArray4 {
    private int nums[];
    private FenwickTree ft;

    public NumArray4(int[] nums) {
        this.nums = nums;
        ft = new FenwickTree(nums);
    }

    public void update(int index, int val) {
        ft.update(index + 1, val - nums[index]);
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return ft.query(right + 1) - ft.query(left);
    }

    private class FenwickTree {
        int backingStore[];

        public FenwickTree(int[] n) {
            backingStore = new int[n.length + 1];
            for(int i = 0; i < n.length; i++) {
                backingStore[i+1] = n[i];
            }
            for(int i = 1; i <= n.length; i++) {
                int p = i + (i & -i);
                if(p <= n.length) {
                    backingStore[p] += backingStore[i];
                }
            }
        }

        public void update(int index, int val) {
            while(index < backingStore.length) {
                backingStore[index] += val;
                index += (index & -index);
            }
        }

        public int query(int index) {
            int sum = 0;
            while(index > 0) {
                sum += backingStore[index];
                index -= (index & -index);
            }

            return sum;
        }
    }
}

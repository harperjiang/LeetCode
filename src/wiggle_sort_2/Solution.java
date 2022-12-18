package wiggle_sort_2;

public class Solution {

    public void wiggleSort(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        int[] counter = new int[5001];
        for (int i = 0; i < nums.length; i++) {
            counter[nums[i]]++;
        }

        int limit = nums.length;
        if (nums.length % 2 == 1) {
            int smallest = 0;
            while (counter[smallest] == 0) smallest++;
            nums[nums.length - 1] = smallest;
            counter[smallest]--;
            limit--;
        }

        int fp = 5000;
        while (counter[fp] == 0) fp--;
        int fc = counter[fp];

        int half = limit / 2;
        int remain = half;
        int sp = 5000;
        while (remain >= counter[sp]) {
            remain -= counter[sp--];
        }
        int sc = counter[sp] - remain;

        for (int i = 0; i < limit; i += 2) {
            nums[i + 1] = fp;
            fc--;
            if (fc == 0) {
                fp--;
                while (fp >= 0 && counter[fp] == 0) fp--;
                if (fp >= 0)
                    fc = counter[fp];
            }
            nums[i] = sp;
            sc--;
            if (sc == 0) {
                sp--;
                while (sp >= 0 && counter[sp] == 0) sp--;
                if (sp >= 0)
                    sc = counter[sp];
            }

        }

        return;
    }

    public static void main(String[] args) {
        new Solution().wiggleSort(new int[]{1, 3, 2, 2, 3, 1});
        new Solution().wiggleSort(new int[]{1, 4, 3, 4, 1, 2, 1, 3, 1, 3, 2, 3, 3});
        new Solution().wiggleSort(new int[]{1, 5, 1, 1, 6, 4});
        new Solution().wiggleSort(new int[]{4, 5, 5, 6});
    }
}

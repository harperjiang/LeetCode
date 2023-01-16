package sum_of_two_integers;

public class Solution {
    public int getSum(int a, int b) {
        int result = 0;
        boolean carry = false;
        for (int i = 0; i < 32; i++) {
            int mask = (1 << i);
            int ma = mask & a;
            int mb = mask & b;
            int value = ma ^ mb;
            if (carry) {
                value ^= mask;
            }
            result |= value;
            carry = (ma != 0 && mb != 0) || (ma != 0 && carry) || (mb != 0 && carry);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getSum(20,30));
    }
}

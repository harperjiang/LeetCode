package integer_replacement;

public class Solution {
    public int integerReplacement(int n) {
        int current = n;
        int loop = 0;
        while (current > 1) {
            if (n == 0 || n == 1) {
                break;
            }
            if (current % 2 == 0) {
                current >>= 1;
                loop++;
            } else if (current == 2147483647) {
                current = 1073741824;
                loop += 2;
            } else {
                // Compare +1 and -1
                int r1 = current + 1;
                int r2 = current - 1;
                int c1 = 0;
                int c2 = 0;
                while (r1 > 1) {
                    c1 += (r1 % 2 == 1) ? 1 : 0;
                    r1 >>= 1;
                }
                while (r2 > 1) {
                    c2 += (r2 % 2 == 1) ? 1 : 0;
                    r2 >>= 1;
                }
                current = c1 <= c2 ? current + 1 : current - 1;
                loop++;
            }
        }
        return loop;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().integerReplacement(2147483647));
//        System.out.println(new Solution().integerReplacement(65535));
        System.out.println(new Solution().integerReplacement(100000000));
    }
}

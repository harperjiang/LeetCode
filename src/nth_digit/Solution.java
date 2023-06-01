package nth_digit;

public class Solution {
    public int findNthDigit(int n) {
        long count = 9;
        long pcount = 0;
        long base = 1;
        long loop = 1;
        while(n > count) {
            base *= 10;
            pcount = count;
            loop++;
            count += base * 9 * loop;
        }
        if(base == 1) {
            return n;
        }
        long index = base + (n - pcount - 1)/loop;
        long offset = (n-pcount-1)%loop;
        for(int i = 0 ; i < loop - offset - 1; i ++) {
            index /=10;
        }
        return (int) (index % 10);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findNthDigit(1000000000));
    }
}

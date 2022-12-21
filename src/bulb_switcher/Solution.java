package bulb_switcher;

public class Solution {
    // 1. After round i, first i bulbs will not change
    // 2. After round i, the i-th bulbs has been changed the number of its factor times
    // only perfect square will be left
    // 25 is there, 125 = 5,25,125
    // 25 = 5,25
    public int bulbSwitch(int n) {
        if (n == 1) {
            return 1;
        }
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (i * i <= n) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}

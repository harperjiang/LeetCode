package gas_station;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] consume = new int[gas.length];
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int record = -1;
        for (int i = 0; i < gas.length; i++) {
            consume[i] = gas[i] - cost[i];
            sum += consume[i];
            min = Math.min(sum, min);
            if (min == sum) {
                record = i;
            }
        }
        if (sum < 0) {
            return -1;
        }
        return (record + 1)%gas.length;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        System.out.println(new Solution().canCompleteCircuit(new int[]{3, 1, 1}, new int[]{1, 2, 2}));
    }
}

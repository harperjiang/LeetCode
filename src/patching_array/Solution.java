package patching_array;

import java.util.*;

public class Solution {

    public int minPatches(int[] nums, int n) {
        int counter = 0;
        int[] borders = new int[nums.length + 2];
        System.arraycopy(nums, 0, borders, 1, nums.length);
        borders[borders.length - 1] = n;

        int hwm = 0;
        for (int i = 1; i < borders.length; i++) {
            if (hwm >= n) {
                break;
            }
            if (hwm >= borders[i] - 1) {
                hwm += borders[i];
            } else {
                int reach = borders[i] - (i == borders.length - 1 ? 0 : 1);
                while (hwm >= 0 && hwm < reach) {
                    counter++;
                    hwm += hwm + 1;
                    if(hwm>=n) break;
                }
                hwm += borders[i];
            }
        }
        return counter;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().minPatches(new int[]{1, 7, 21, 31, 34, 37, 40, 43, 49, 87, 90, 92, 93, 98, 99}, 12));
//        System.out.println(new Solution().minPatches(new int[]{2, 6, 7, 11, 25, 28, 35, 37, 52, 58, 64, 65, 67, 71, 82, 95}, 22));
//        System.out.println(new Solution().minPatches(new int[]{1, 3}, 6));
//        System.out.println(new Solution().minPatches(new int[]{1, 5, 10}, 20));
//        System.out.println(new Solution().minPatches(new int[]{1, 18, 19}, 20));
//        System.out.println(new Solution().minPatches(new int[]{1, 2, 2}, 5));
//        System.out.println(new Solution().minPatches(new int[]{1, 2, 31, 33}, 2147483647));
//        System.out.println(new Solution().minPatches(new int[]{10, 30, 36, 42, 50, 76, 87, 88, 91, 92}, 54));
        System.out.println(new Solution().minPatches(new int[]{1, 2, 2, 6, 34, 38, 41, 44, 47, 47, 56, 59, 62, 73, 77, 83, 87, 89, 94}, 20));
    }

    // Seems the number of patches is (nums[0]+1)/2
    // tofill == 7 => 3
    // 1,2,4
    // tofill == 8 => 4
    // 1-4 1,2,3,4 need 1-4  1,1,2,4 can fill 8
    // 1-4 and a single 4
    // tofill == 9 => 4
    // 1-4 and a single 5, 1,1,2,5 can fill 9
    // tofill = 10 => 4
    // all numbers to form 1-5 and a single 5
    // 1,2,2,5 can fill up to 5,
    // tofill == 11 => 4
    // all numbers of 1-5 and a single 6
    // tofill == 12 => 4
    // 1-6 and a 6, 1,2,3,6
    // We already have numbers to fill up to hwm, how many min more to fill to gap
}

package sort_transformed_array;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] result = new int[nums.length];
        int pointer = 0;

        if (a == 0 && b == 0) {
            Arrays.fill(result, c);
        } else if (a != 0 && (-b / (2 * a)) > nums[0] && (-b / (2 * a) < nums[nums.length - 1])) {
            double center = -(float)b / (2 * a);
            if (a > 0) {
                int l = (int) center;
                int lp = Arrays.binarySearch(nums, l);
                if (lp < 0) {
                    lp = -lp - 1;
                }
                int rp = lp;
                lp = rp - 1;

                while (lp >= 0 || rp < nums.length) {
                    int i = 0;
                    if (lp == rp) {
                        i = lp--;
                    } else {
                        if (lp < 0) {
                            i = rp++;
                        } else if (rp >= nums.length) {
                            i = lp--;
                        } else if (Math.abs(nums[lp] - center) <= Math.abs(nums[rp] - center)) {
                            i = lp--;
                        } else {
                            i = rp++;
                        }
                    }
                    result[pointer++] = a * nums[i] * nums[i] + b * nums[i] + c;
                }
            } else {
                int lp = 0, rp = nums.length - 1;
                while (lp <= rp) {
                    int i = 0;
                    if (Math.abs(nums[lp] - center) >= Math.abs(nums[rp] - center)) {
                        i = lp++;
                    } else {
                        i = rp--;
                    }
                    result[pointer++] = a * nums[i] * nums[i] + b * nums[i] + c;
                }
            }
        } else {
            int start = 0;
            int step = 0;
            if (a == 0) {
                start = b > 0 ? 0 : nums.length - 1;
                step = b > 0 ? 1 : -1;
            } else {
                double center = -b / (2 * a);
                if ((center <= nums[0] && a > 0) || (center >= nums[nums.length - 1] && a < 0)) {
                    step = 1;
                } else {
                    start = nums.length - 1;
                    step = -1;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                result[i] = a * nums[start] * nums[start] + b * nums[start] + c;
                start += step;
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().sortTransformedArray(new int[]{-4, -2, 2, 4}, 1, 3, 5));
//        System.out.println(new Solution().sortTransformedArray(new int[]{-4, -2, 2, 4}, -1, 3, 5));
//        System.out.println(new Solution().sortTransformedArray(new int[]{-4, -2, 2, 4}, 0, -1, 5));
        System.out.println(new Solution().sortTransformedArray(new int[]{-95,-95,-93,-92,-89,-89,-88,-82,-81,-79,-71,-71,-66,-66,-65,-65,-62,-61,-60,-54,-54,-51,-50,-48,-47,-45,-43,-37,-35,-35,-32,-32,-29,-24,-24,-22,-20,-20,-17,-14,-13,-12,-12,-4,1,8,11,14,16,16,22,24,26,28,28,28,29,30,31,36,44,46,49,60,60,60,62,64,65,73,76,86,87,89,91,92,93,94,94,96,96,97}, 41, 45, -89));
    }
}

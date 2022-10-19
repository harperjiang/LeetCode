package container_with_most_water;

public class Solution {

    public int maxArea(int[] height) {
        int fp = 0;
        int ep = height.length - 1;
        int max = Math.min(height[fp], height[ep]) * (ep - fp);

        while (fp < ep) {
            if (height[fp] <= height[ep]) {
                fp++;
            } else {
                ep--;
            }
            max = Math.max(max, Math.min(height[fp], height[ep]) * (ep - fp));
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(new Solution().maxArea(new int[]{1, 1}));
    }
}

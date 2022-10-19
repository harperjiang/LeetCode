package trapping_rain_water;

/**
 * Created by harper on 10/14/17.
 */
class Solution {
    public int trap(int[] height) {
        if (height.length == 0 || height.length == 1)
            return 0;
        int left = 0;
        int right = height.length - 1;
        int water = 0;
        int level = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                level = Integer.max(height[left], level);
                water += level - height[left];
                left++;
            } else {
                level = Integer.max(height[right], level);
                water += level - height[right];
                right--;
            }
        }
        return water;
    }
}

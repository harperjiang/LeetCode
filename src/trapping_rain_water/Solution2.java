package trapping_rain_water;

public class Solution2 {
    public int trap(int[] height) {
        if(height.length <=2) {
            return 0;
        }
        int[][] maxafter = new int[height.length][];
        int max = height[height.length-1];
        int mindex = height.length-1;
        maxafter[height.length-1]= new int[]{0,-1};
        for(int i = height.length-2 ; i >=0 ;i--) {
            maxafter[i] = new int[]{max,mindex};
            if(height[i]>max) {
                max = height[i];
                mindex = i;
            }
        }
        // Count water afterward
        int watersum = 0;
        int pointer = 0;

        while(pointer < height.length) {
            if(maxafter[pointer][0] <= height[pointer]) {
                int rectsum = maxafter[pointer][0]* (maxafter[pointer][1] - pointer-1);
                for(int i = pointer+1;i<maxafter[pointer][1];i++) {
                    rectsum -= height[i];
                }
                watersum += rectsum;
                pointer = maxafter[pointer][1];
                if(pointer==-1) {
                    break;
                }
            } else {
                int i = pointer+1;
                while(height[i]<=height[pointer]) {
                    watersum+=height[pointer]-height[i];
                    i++;
                }
                pointer=i;
            }
        }

        return watersum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}

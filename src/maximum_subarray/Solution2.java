package maximum_subarray;

/**
 * Divide and Conquer
 */
public class Solution2 {
    public int maxSubArray(int[] nums) {
        // Initialize currMaxSum & take first element of array from which we start to do sum...
        int maxSum = nums[0];
        // Initialize the current sum of our subarray as nums[0]...
        int currSum = nums[0];
        // Traverse all the element through the loop...
        for (int i = 1; i < nums.length; i++) {
            // Do sum of elements contigous with curr sum...
            // Compare it with array element to get maximum result...
            currSum = Math.max(currSum + nums[i], nums[i]);
            // Compare current sum and max sum.
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;      // return the contiguous subarray which has the largest sum...
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().maxSubArray(new int[]{1}));
    }
}

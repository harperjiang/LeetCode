package count_ways_to_build_good_strings;

public class Solution {

    public int countGoodStrings(int low, int high, int zero, int one) {
        int count = 0;
        long[] array = new long[high+1];
        array[0] = 0;
        array[zero] += 1;
        array[one]+= 1;
        for(int i = 1 ; i < array.length; i++) {
            if(i+zero < array.length) {
                array[i+zero] += array[i];
                array[i+zero]%= 1e9+7;
            }
            if(i+one < array.length) {
                array[i+one] += array[i];
                array[i+one]%= 1e9+7;
            }
        }
        for(int i = low;i<=high;i++) {
            count += array[i];
            count%=1e9+7;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countGoodStrings(200,200,1,10));
    }
}
package count_of_range_sum;

import java.util.*;

public class MyFirstSolution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] csarray = new long[nums.length];
        List<Long> cumsums = new ArrayList<>();
        cumsums.add((long) nums[0]);
        csarray[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            csarray[i] = csarray[i - 1] + nums[i];
            cumsums.add(csarray[i]);
        }
        Collections.sort(cumsums);
        int counter = 0;
        int start = Collections.binarySearch(cumsums, (long) lower);
        int end = Collections.binarySearch(cumsums, (long) upper);
        if (start < 0) {
            start = -start - 1;
        } else {
            while (start >= 0 && cumsums.get(start) == lower) start--;
            if (start < 0 || cumsums.get(start) != lower)
                start++;
        }
        if (end < 0) {
            end = -end - 1;
        } else {
            while (end < nums.length && cumsums.get(end) == upper) end++;
        }
        counter += end - start;


        for (int i = 0; i < nums.length; i++) {
            long nl = lower + csarray[i];
            long nu = upper + csarray[i];
            int index = Collections.binarySearch(cumsums,csarray[i]);
            cumsums.remove(index);
            start = Collections.binarySearch(cumsums, nl);
            end = Collections.binarySearch(cumsums, nu);
            if (start < 0) {
                start = -start - 1;
            } else {
                while (start >= 0 && cumsums.get(start) == nl) start--;
                if (start < 0 || cumsums.get(start) != nl)
                    start++;
            }
            if (end < 0) {
                end = -end - 1;
            } else {
                while (end < cumsums.size() && cumsums.get(end) == nu) end++;
            }
            counter += end - start;
        }

        return counter;
    }

    public static void main(String[] args) {
        System.out.println(new MyFirstSolution().countRangeSum(new int[]{-2, 5, -1}, -2, 2));
        System.out.println(new MyFirstSolution().countRangeSum(new int[]{0}, 0, 0));
        System.out.println(new MyFirstSolution().countRangeSum(new int[]{0, 0}, 0, 0));
        System.out.println(new MyFirstSolution().countRangeSum(new int[]{2147483647, -2147483648, -1, 0}, -1, 0));
        System.out.println(new MyFirstSolution().countRangeSum(new int[]{-2147483647, 0, -2147483647, 2147483647}, -564, 3864));
    }
}

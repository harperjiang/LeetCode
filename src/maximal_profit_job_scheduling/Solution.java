package maximal_profit_job_scheduling;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    int[][] jobs;
    int[] max;

    // Return the maximal profit starting from index
    public int judge(int index) {
        if (index >= max.length) return 0;
        if (max[index] != 0) // Already searched before
            return max[index];
        if (index == jobs.length - 1) {// last one
            max[index] = jobs[index][2];
            return max[index];
        }
        // find the last index that overlap with index
        int deadline = jobs[index][1];
        // Search for the first non-overlapping interval after index
        int cover = Arrays.binarySearch(jobs, index, jobs.length, new int[]{deadline, 0, 0},
                Comparator.comparing((int[] j) -> j[0]));
        if (cover >= 0) {
            while (cover >= 0 && jobs[cover][0] == deadline) cover--;
            if(jobs[cover][0]<deadline)cover++;
        } else {
            cover = -cover - 1;
        }

        int result = 0;
        // overlap between index + 1 and cover
        if (cover == index) { // No overlap, maximal profit is this plus next step
            result = jobs[index][2] + judge(index + 1);
        } else {
            result = Math.max(jobs[index][2] + judge(cover), judge(index + 1));
        }

        this.max[index] = result;
        return result;
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        this.jobs = new int[startTime.length][3];
        this.max = new int[startTime.length];
        for (int i = 0; i < jobs.length; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, Comparator.comparing((i) -> i[0]));
        return judge(0);
    }

    public static void main(String[] args) {
        System.out.println(new Solution()
                .jobScheduling(new int[]{1, 2, 3, 3}, new int[]{3, 4, 5, 6}, new int[]{50, 10, 40, 70}));
        System.out.println(new Solution()
                .jobScheduling(new int[]{1, 2, 3, 4, 6}, new int[]{3, 5, 10, 6, 9}, new int[]{20, 20, 100, 70, 60}));
        System.out.println(new Solution()
                .jobScheduling(new int[]{1, 1, 1}, new int[]{2, 3, 4}, new int[]{5, 6, 4}));
        System.out.println(new Solution()
                .jobScheduling(new int[]{4, 2, 4, 8, 2}, new int[]{5, 5, 5, 10, 8}, new int[]{1, 2, 8, 10, 4}));
    }
}

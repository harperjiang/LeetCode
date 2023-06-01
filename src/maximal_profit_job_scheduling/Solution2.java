package maximal_profit_job_scheduling;

import java.util.Arrays;
import java.util.Comparator;

public class Solution2 {
    int[][] jobs;
    int[] max;

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        this.jobs = new int[startTime.length][3];
        this.max = new int[startTime.length];
        for (int i = 0; i < jobs.length; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, Comparator.comparing((i) -> i[0]));

        max[jobs.length - 1] = jobs[jobs.length - 1][2];
        for (int i = jobs.length - 2; i >= 0; i--) {
            // Choose this job
            int deadline = jobs[i][1];
            int cover = Arrays.binarySearch(jobs, i, jobs.length, new int[]{deadline, 0, 0},
                    Comparator.comparing((int[] j) -> j[0]));
            if (cover >= 0) {
                while (cover >= 0 && jobs[cover][0] == deadline) cover--;
                if(jobs[cover][0]<deadline)cover++;
            } else {
                cover = -cover - 1;
            }
            max[i] = jobs[i][2] + (cover>=jobs.length?0:max[cover]);
            // Do not choose this job
            max[i] = Math.max(max[i], max[i + 1]);
        }

        return max[0];
    }

    public static void main(String[] args) {
        System.out.println(new Solution2()
                .jobScheduling(new int[]{1, 2, 3, 3}, new int[]{3, 4, 5, 6}, new int[]{50, 10, 40, 70}));
//        System.out.println(new Solution2()
//                .jobScheduling(new int[]{1, 2, 3, 4, 6}, new int[]{3, 5, 10, 6, 9}, new int[]{20, 20, 100, 70, 60}));
//        System.out.println(new Solution2()
//                .jobScheduling(new int[]{1, 1, 1}, new int[]{2, 3, 4}, new int[]{5, 6, 4}));
//        System.out.println(new Solution2()
//                .jobScheduling(new int[]{4, 2, 4, 8, 2}, new int[]{5, 5, 5, 10, 8}, new int[]{1, 2, 8, 10, 4}));
    }
}

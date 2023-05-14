package task_scheduler;

import java.util.*;

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26];
        int remain = 0;

        for(char c: tasks) {
            counter[c-'A']++;
            remain++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing((int[] i)->-i[1]));
        Queue<int[]> buffer = new ArrayDeque<>();
        for(int i = 0 ; i < 26;i++) {
            if(counter[i]>0) {
                pq.add(new int[]{i, counter[i]});
            }
        }
        int round = 0;
        while(remain > 0) {
            if(!pq.isEmpty()) {
                int[] next = pq.poll();
//                System.out.println((char)('A'+next[0]));
                if(next[1]>1) {
                    buffer.add(new int[]{next[0], next[1] - 1});
                } else {
                    buffer.add(new int[]{-1,0});
                }
                remain --;
            } else {
//                System.out.print((char)(' '));
                buffer.add(new int[]{-1,0});
            }
            while(buffer.size()> n) {
                int[] next = buffer.poll();
                if(next[0]!=-1)
                    pq.add(next);
            }
            round++;
        }
        return round;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'},2));
    }
}

package merge_intervals;

import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    static class Index {

        int nlevel;
        int[] indexs;
        List<int[]> intervals = new ArrayList<>();

        public Index(int level) {
            nlevel = level;
            indexs = new int[(1 << (nlevel + 1)) - 1];
            Arrays.fill(indexs, -1);
        }

        int convert(int level, int pos) {
            int base = (1 << (nlevel - level)) - 1;
            return base + pos;
        }

        // Where to put the item in the index
        List<Integer> position(int[] interval) {
            List<Integer> result = new ArrayList<>();
            int fp = interval[0];
            int lp = interval[1];
            int level = 0;
            while (fp < lp) {
                boolean fmb = (fp & 1) == 1;
                boolean lmf = (lp & 1) == 0;
                if (fmb) {
                    result.add(convert(level, fp));
                }
                if (lmf) {
                    result.add(convert(level, lp));
                }
                fp >>= 1;
                fp += fmb ? 1 : 0;
                lp >>= 1;
                lp -= lmf ? 1 : 0;
                level++;
            }
            if (fp == lp) {
                result.add(convert(level, fp));
            }
            return result;
        }

        // Check if there is one overlap
        int check(int[] interval) {
            for (int i = nlevel; i >= 0; --i) {
                int psize = 1 << i;
                int fp = interval[0] / psize;
                int lp = interval[1] / psize;
                for (int j = fp; j <= lp; ++j) {
                    int indexpos = convert(i, j);
                    if (indexs[indexpos] != -1) {
                        return indexs[indexpos];
                    }
                }
            }
            return -1;
        }

        void add(int[] interval) {
            int[] tomerge = new int[2];
            tomerge[0] = interval[0];
            tomerge[1] = interval[1];
            int existidx = -1;
            while ((existidx = check(tomerge)) != -1) {
                int[] exist = intervals.get(existidx);
                intervals.set(existidx, null);
                // Clear exist
                for (int pos : position(exist)) {
                    indexs[pos] = -1;
                }
                tomerge[0] = Math.min(tomerge[0], exist[0]);
                tomerge[1] = Math.max(tomerge[1], exist[1]);
            }
            int index = intervals.size();
            intervals.add(tomerge);
            for (int pos : position(tomerge)) {
                indexs[pos] = index;
            }
        }

        int[][] list() {
            List<int[]> valid = intervals.stream().filter(i -> i != null).collect(Collectors.toList());
            int[][] result = new int[valid.size()][];
            for (int i = 0; i < result.length; ++i) {
                result[i] = valid.get(i);
            }
            return result;
        }
    }

    public int[][] merge(int[][] intervals) {
        int max = 0;
        for (int[] interval : intervals) {
            max = Math.max(interval[1], max);
        }
        int msb = 0;
        while (max > 0) {
            max >>= 1;
            msb += 1;
        }
        Index index = new Index(msb);
        for (int[] interval : intervals) {
            index.add(interval);
        }
        return index.list();
    }

    public static void main(String[] args) {
        int[][] res = new Solution().merge(new int[][]{
                new int[]{1, 3},
                new int[]{2, 6},
                new int[]{8, 10},
                new int[]{15, 18}});

        System.out.println(Arrays.stream(res)
                .map(iv -> MessageFormat.format("{0},{1}", iv[0], iv[1])).collect(Collectors.joining("\n")));
    }

}

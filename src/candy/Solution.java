package candy;

/**
 * Created by harper on 10/2/17.
 */
public class Solution {

    public int candy(int[] ratings) {
        // One pass to look for local max and local min
        if (ratings.length == 0)
            return 0;
        if (ratings.length == 1)
            return 1;
        if (ratings.length == 2) {
            return ratings[0] == ratings[1] ? 2 : 3;
        }

        int sum = 0;
        int current = 1;
        int lastTop = -1;
        boolean lastTopStable = false;
        boolean asc = false;
        boolean stable = false;
        int stableBegin = 0;

        if (ratings[0] > ratings[1]) {
            sum = 2;
            current = 2;
            asc = false;
            stable = false;
            lastTop = 0;
        }
        if (ratings[0] == ratings[1]) {
            sum = 1;
            asc = false;
            stable = true;
            lastTop = 1;
        }
        if (ratings[0] < ratings[1]) {
            sum = 1;
            asc = true;
            stable = false;
        }
        for (int i = 1; i < ratings.length; i++) {
            int oldCurrent = current;
            boolean oldAsc = asc;
            int oldLastTop = lastTop;
            boolean oldLastTopStable = lastTopStable;
            if (ratings[i] > ratings[i - 1]) {
                if (!asc && current != 1) {
                    sum -= (i - lastTop - (lastTopStable ? 0 : 1)) * (current - 1);
                    current = 1;
                }
                asc = true;
                current += 1;

                // reduce all between stable to 1
                if (stable) {
                    if (oldAsc) {
                        sum -= (i - stableBegin - 1) * (oldCurrent - 1);
                        current = 2;
                    } else {
                        // current should already be 1
                    }
                }

                stable = false;
            }
            if (ratings[i] < ratings[i - 1]) {
                if (asc) {
                    lastTop = i - 1;
                    lastTopStable = stable;
                }
                current -= 1;
                if (current < 1) {
                    sum += i - lastTop;
                    current = 1;
                }
                asc = false;

                // Reduce all stables between
                if (stable) {
                    if (oldAsc) {
                        sum -= (i - stableBegin - 2) * (oldCurrent - 1);
                    } else {
                        sum -= (i - stableBegin - 1) * (oldCurrent - 1);
                        if (oldLastTopStable) {
                            sum -= oldCurrent - 1;
                        }
                    }
                    lastTop = i - 1;
                }

                stable = false;
            }
            if (ratings[i] == ratings[i - 1]) {
                if (!stable) {
                    stableBegin = i - 1;
                }
                stable = true;
                if (lastTop == i - 1) {
                    lastTop = i;
                }
            }
            sum += current;
        }
        if (stable && lastTop == -1) {
            lastTop = ratings.length - 1;
        }
        if (stable) {
            if (current != 1) {
                sum -= (ratings.length - 1 - stableBegin) * (current - 1);
            }
        } else if (!asc) {
            if (current != 1) {
                if (lastTopStable) {
                    sum -= (ratings.length - lastTop) * (current - 1);
                } else {
                    sum -= (ratings.length - lastTop - 1) * (current - 1);
                }
            }

        }
        return sum;
    }
}

package elimination_game;

public class Solution {

    int get(int remain, boolean head) {
        if (remain == 4) {
            return head ? 2 : 3;
        }
        if (remain == 3) {
            return 2;
        }
        if (remain == 2) {
            return head ? 1 : 2;
        }
        if (remain == 1) {
            return 1;
        }
        int childremain = get(remain / 2, !head);
        return (remain % 2 == 0 && !head) ? (childremain * 2 - 1) : childremain * 2;
    }

    public int lastRemaining(int n) {
        return get(n, true);
    }


}

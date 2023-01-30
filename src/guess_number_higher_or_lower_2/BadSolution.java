package guess_number_higher_or_lower_2;

import java.text.MessageFormat;

public class BadSolution {

    int[] recursive(int n) {
        if (n == 0) {
            return new int[]{-1, 0};
        }
        if (n == 1) {
            return new int[]{0, 0};
        }
        if (n == 2) {
            return new int[]{1, 1};
        }
        if (n == 3) {
            return new int[]{2, 1};
        }
        if (n == 4) {
            return new int[]{4, 2};
        }
        if (n == 5) {
            return new int[]{6, 2};
        }
        if (buffer[n] != null) {
            return buffer[n];
        }
        int min = Integer.MAX_VALUE;
        int cmin = -1;
        int imindx = -1;
        for (int i = 1; i <= n; i++) {
            int[] fhalf = recursive(i - 1);
            int[] shalf = recursive(n - i);
            int imin, cimin;
            imin = i + Math.max(fhalf[0], shalf[0] + shalf[1] * i);
            cimin = Math.max(fhalf[1], shalf[1]) + 1;
            if (imin < min) {
                min = imin;
                cmin = cimin;
                imindx = i;
            }
        }
        System.out.println(MessageFormat.format("{0},{1}={2},{3}", n, imindx, min, cmin));
        buffer[n] = new int[]{min, cmin};
        return buffer[n];
    }

    int[][] buffer = new int[201][];

    public int getMoneyAmount(int n) {
        return recursive(n)[0];
    }

    public static void main(String[] args) {
        System.out.println(new BadSolution().getMoneyAmount(62));
    }
}

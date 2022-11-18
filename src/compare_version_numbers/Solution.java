package compare_version_numbers;

public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] pv1 = version1.split("\\.");
        String[] pv2 = version2.split("\\.");

        int comparesize = Math.min(pv1.length, pv2.length);
        for (int i = 0; i < comparesize; i++) {
            int segv1 = Integer.valueOf(pv1[i]);
            int segv2 = Integer.valueOf(pv2[i]);
            if (segv1 != segv2) {
                return (segv1 - segv2) / Math.abs(segv1 - segv2);
            }
        }
        String[] longer = pv1.length == comparesize ? pv2 : pv1;
        for (int i = comparesize; i < longer.length; i++) {
            if (Integer.valueOf(longer[i]) > 0) {
                return longer == pv1 ? 1 : -1;
            }
        }
        return 0;
    }
}

package rectangle_area;

public class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // first check if x overlaps
        int overlap = 0;
        if (bx1 >= ax2 || ax1 >= bx2 || by1 >= ay2 || ay1 >= by2) {
        } else {
            int width = Math.min(ax2, bx2) - Math.max(ax1, bx1);
            int height = Math.min(ay2, by2) - Math.max(ay1, by1);
            overlap = width * height;
        }
        return (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1) - overlap;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }
}

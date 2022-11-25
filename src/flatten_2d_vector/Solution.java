package flatten_2d_vector;

public class Solution {

    public static void main(String[] args) {
        Vector2D v = new Vector2D(new int[][]{{1,2},{3},{4}});
        System.out.println(v.next());
        System.out.println(v.next());
        System.out.println(v.next());
        System.out.println(v.hasNext());
        System.out.println(v.hasNext());
        System.out.println(v.next());
        System.out.println(v.hasNext());
    }
}

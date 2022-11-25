package flatten_2d_vector;

public class Vector2D {

    int[][] vector;
    int x;
    int y;

    public Vector2D(int[][] vec) {
        vector = vec;
        x = 0;
        y = 0;
        while (x < vector.length && vector[x].length == 0) {
            x++;
        }
    }

    public int next() {
        if (y == vector[x].length) {
            x++;
            while (x < vector.length && vector[x].length == 0) {
                x++;
            }
            y = 0;
        }
        return vector[x][y++];
    }

    public boolean hasNext() {
        if (x >= vector.length) {
            return false;
        }
        if (y < vector[x].length) {
            return true;
        }
        x++;
        while (x < vector.length && vector[x].length == 0) {
            x++;
        }
        y = 0;
        return x < vector.length;
    }
}

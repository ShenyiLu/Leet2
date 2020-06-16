package medium;

public class L251Vector2D {
    private int width;
    private int height;
    private int[][] v;

    public L251Vector2D(int[][] v) {
        this.v = v;
        width = 0;
        while (width < v.length && v[width].length == 0) {
            width++;
        }
        height = 0;
    }

    public int next() {
        int result = v[width][height];
        if (height < v[width].length - 1) {
            height++;
        } else {
            do {
                width++;
            } while (width < v.length && v[width].length == 0);
            height = 0;
        }
        return result;
    }

    public boolean hasNext() {
        return (width < v.length && height < v[width].length);
    }
}

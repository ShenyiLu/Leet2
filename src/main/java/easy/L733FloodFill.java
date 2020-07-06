package easy;

public class L733FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor == newColor) {
            return image;
        }

        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        flood(image, sr, sc, oldColor, newColor, directions);
        return image;
    }

    private void flood(int[][] image, int x, int y, int oldColor, int newColor, int[][] directions) {
        image[x][y] = newColor;
        for (int[] direction : directions) {
            int x1 = x + direction[0];
            int y1 = y + direction[1];

            if (isValidCoordinate(x1, y1, image) && image[x1][y1] == oldColor) {
                flood(image, x1, y1, oldColor, newColor, directions);
            }
        }
    }

    private boolean isValidCoordinate(int x, int y, int[][] image) {
        return !(x < 0 || x > image.length || y < 0 || y > image[0].length);
    }
}

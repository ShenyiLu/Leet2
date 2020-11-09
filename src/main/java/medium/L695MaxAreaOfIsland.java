package medium;

public class L695MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == 1) {
                    maxArea = Math.max(maxArea, dfs(x, y, grid, directions));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int x, int y, int[][] grid, int[][] directions) {
        if (grid[x][y] != 1) {
            return 0;
        }
        grid[x][y] = 2;
        int sum = 1;
        for (int[] direction : directions) {
            int x1 = x + direction[0];
            int y1 = y + direction[1];
            if (!isValid(x1, y1, grid) || grid[x1][y1] != 1) {
                sum += 0;
            } else {
                sum += dfs(x1, y1, grid, directions);
            }
        }
        return sum;
    }

    private boolean isValid(int x, int y, int[][] grid) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}

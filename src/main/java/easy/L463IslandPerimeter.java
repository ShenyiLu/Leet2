package easy;

public class L463IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == 1) {
                    return dfs(x, y, grid, directions);
                }
            }
        }
        return 0;
    }

    private int dfs(int x, int y, int[][] grid, int[][] directions) {
        if (grid[x][y] != 1) {
            return 0;
        }
        grid[x][y] = 2;
        int sum = 0;
        for (int[] direction : directions) {
            int x1 = x + direction[0];
            int y1 = y + direction[1];
            if (!isValid(x1, y1, grid) || grid[x1][y1] == 0) {
                sum += 1;
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

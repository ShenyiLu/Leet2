package hard;

public class L329LongestIncreasingPath {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int height = matrix.length;
        int width = matrix[0].length;
        // init dp array
        int[][] dp = new int[height][width];
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int maxLength = 0;
        for (int hIndex = 0; hIndex < height; hIndex++) {
            for (int wIndex = 0; wIndex < width; wIndex++) {
                if (dp[hIndex][wIndex] == 0) {
                    maxLength = Math.max(maxLength, dfs(hIndex, wIndex, matrix, directions, dp));
                }
            }
        }
        return maxLength;
    }

    private int dfs(int x, int y, int[][] matrix, int[][] directions, int[][] dp) {
        int pathLength = 1;
        for (int[] direction : directions) {
            int x1 = x + direction[0];
            int y1 = y + direction[1];
            // check boundary
            if (Math.min(x1, y1) < 0 || x1 >= matrix.length || y1 >= matrix[0].length) {
                continue;
            }
            // check value
            if (matrix[x][y] >= matrix[x1][y1]) {
                continue;
            }
            // run dp
            int possibleLength = 1 + (dp[x1][y1] > 0 ? dp[x1][y1] : dfs(x1, y1, matrix, directions, dp));
            pathLength = Math.max(pathLength, possibleLength);
        }
        dp[x][y] = pathLength;
        return pathLength;
    }
}

package medium;

public class L221MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        // get rid of special cases
        int height = matrix.length;
        if (height == 0) {
            return 0;
        }

        int width = matrix[0].length;
        if (width == 0) {
            return 0;
        }


        if (height == 1) {
            for (int i = 0; i < width; i++) {
                if (matrix[0][i] == '1') {
                    return 1;
                }
            }
            return 0;
        }
        if (width == 1) {
            for (int i = 0; i < height; i++) {
                if (matrix[i][0] == '1') {
                    return 1;
                }
            }
            return 0;
        }

        // init the dp
        int[] dp = new int[width];
        int[] pre = new int[width];
        int max = 0;

        for (int y = 0; y < height; y++) {
            dp[0] = matrix[y][0] - '0';
            for (int x = 1; x < width; x++) {
                if (matrix[y][x] - '0' > 0) {
                    dp[x] = Math.min(dp[x], Math.min(dp[x - 1], pre[x])) + 1;
                } else {
                    dp[x] = 0;
                }
            }
            for (int x = 0; x < width; x++) {
                if (x < width - 1) {
                    pre[x + 1] = dp[x];
                }
                System.out.print(dp[x] + " ");
                max = Math.max(max, dp[x]);
            }
            System.out.println();
        }

        return max * max;
    }
}

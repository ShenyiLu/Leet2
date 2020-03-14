package oa;

import java.util.List;

public class TuSimpleMNcut {
    public boolean cut(int[][] input, int m, int n) {
        // cut matrix into (m+1)*(n+1) pieces
        if (m < 0 || n < 0 || input.length < n || input[0].length < m) {
            return false;
        }
        if (m == 0 && n == 0) {
            return true;
        }
        int sum = 0;
        for (int height = 0; height < input.length; height++) {
            for (int width = 0; width < input[0].length; width++) {
                sum += input[height][width];
            }
        }
        if (sum == 0) {
            return true;
        }
        if (sum % ((m + 1) * (n + 1)) != 0) {
            return false;
        }
        // expected number of 1s per piece
        int perPiece = sum / ((m + 1) * (n + 1));
        int[][] dp = dp(input);
        return false;
    }

    // build dp matrix
    private int[][] dp(int[][] input) {
        int[][] result = new int[input.length][input[0].length];
        result[0][0] = input[0][0];

        for (int height = 1; height < input.length; height++) {
            result[height][0] = result[height - 1][0] + input[height][0];
        }

        for (int width = 1; width < input[0].length; width++) {
            result[0][width] = result[0][width - 1] + input[0][width];
        }

        for (int height = 1; height < input.length; height++) {
            for (int width = 1; width < input[0].length; width++) {
                result[height][width] = result[height - 1][width] + result[height][width - 1] + input[height][width];
            }
        }
        return result;
    }

    // see if it is possible to divide
    // y, x: starting point for this round of dfs
    // perPiece: expected number of 1s per piece
    // lastViablePiece:
    private void dfs(int[][] input, int m, int n, int y, int x, int perPiece, List<Integer> lastDivide) {

    }

}

package medium;

public class L304NumMatrix {
    int[][] sum;
    public L304NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            sum = null;
            return;
        }
        int y = matrix.length;
        int x = matrix[0].length;
        sum = new int[y][x];
        for (int i = 0; i < y; i++) {
            sum[i][0] = matrix[i][0];
            for (int j = 1; j < sum[0].length; j++) {
                sum[i][j] = sum[i][j - 1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (sum == null) {
            return 0;
        }

        int result = 0;

        if (col1 == 0) {
            for (int i = row1; i <= row2; i++) {
                result += sum[i][col2];
            }
        } else {
            for (int i = row1; i <= row2; i++) {
                result += (sum[i][col2] - sum[i][col1 - 1]);
            }
        }
        return result;
    }
}

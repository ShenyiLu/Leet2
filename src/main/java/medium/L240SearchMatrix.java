package medium;

public class L240SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int y = 0;
        int x = matrix[0].length - 1;
        while (x >= 0 && y < matrix.length) {
            int current = matrix[y][x];
            if (current == target) {
                return true;
            }
            if (current > target) {
                x--;
            }
            if (current < target) {
                y++;
            }
        }
        return false;
    }
}

package medium;

public class L498FindDiagonalOrder {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }

        int height = matrix.length;
        int width = matrix[0].length;

        int[] result = new int[height * width];
        int index = 0;

        int upperHeightIndex = 0;
        int upperWidthIndex = 0;
        int lowerHeightIndex = 0;
        int lowerWidthIndex = 0;

        while (lowerWidthIndex <= matrix[0].length) {
            if ((upperHeightIndex + upperWidthIndex) % 2 == 0) {
                // go up
                int tempHeight = lowerHeightIndex;
                int tempWidth = lowerWidthIndex;
                while (tempHeight >= upperHeightIndex) {
                    result[index] = matrix[tempHeight][tempWidth];
                    tempHeight--;
                    tempWidth++;
                    index++;
                }
            } else {
                // go down
                int tempHeight = upperHeightIndex;
                int tempWidth = upperWidthIndex;
                while (tempHeight <= lowerHeightIndex) {
                    result[index] = matrix[tempHeight][tempWidth];
                    tempHeight++;
                    tempWidth--;
                    index++;
                }
            }
            if (upperWidthIndex < width - 1) {
                upperWidthIndex++;
            } else {
                upperHeightIndex++;
            }
            if (lowerHeightIndex < height - 1) {
                lowerHeightIndex++;
            } else {
                lowerWidthIndex++;
            }
        }

        return result;
    }
}

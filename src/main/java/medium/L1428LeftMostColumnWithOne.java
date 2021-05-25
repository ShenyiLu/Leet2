package medium;

import java.util.ArrayList;
import java.util.List;

public class L1428LeftMostColumnWithOne {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimension = binaryMatrix.dimensions();
        int maxRow = dimension.get(0);
        int maxCol = dimension.get(1);
        if (getColSum(binaryMatrix, maxRow, maxCol - 1) == 0) {
            return -1;
        }

        // already checked last col, must have a solution
        int startCol = 0;
        int endCol = maxCol - 1;
        if (startCol == endCol) {
            return startCol;
        }

        while (startCol < endCol) {
            if (startCol + 1 == endCol) {
                if (getColSum(binaryMatrix, maxRow, startCol) == 0) {
                    return endCol;
                } else {
                    return startCol;
                }
            }
            int midCol = (startCol + endCol) / 2;
            int midColSum = getColSum(binaryMatrix, maxRow, midCol);
            if (midColSum > 0) {
                endCol = midCol;
            } else {
                startCol = midCol;
            }
        }
        return -1;
    }

    private int getColSum(BinaryMatrix binaryMatrix, int maxRow, int currCol) {
        int sum = 0;
        for (int row = 0; row < maxRow; row++) {
            sum += binaryMatrix.get(row, currCol);
        }
        return sum;
    }

    private class BinaryMatrix {
        public int get(int row, int col) {
            return 0;
        }

        public List<Integer> dimensions() {
            return new ArrayList<>();
        }
    }
}

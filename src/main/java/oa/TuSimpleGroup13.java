package oa;

import java.util.ArrayList;
import java.util.List;

public class TuSimpleGroup13 {
    public static List<List<Integer>> findBeforeMatrix(List<List<Integer>> after) {
        // Write your code here
        if (after.size() == 0 || after.get(0).size() == 0) {
            return after;
        }
        if (after.size() == 1 && after.get(0).size() == 1) {
            return after;
        }

        int y = after.size();
        int x = after.get(0).size();
        int[][] afterMatrix = new int[y][x];
        int[][] beforeMatrix = new int[y][x];
        for (int i = 0; i < after.size(); i++) {
            for (int j = 0; j < after.get(0).size(); j++) {
                afterMatrix[i][j] = after.get(i).get(j);
            }
        }

        for (int yIndex = y - 1; yIndex > 0; yIndex--) {
            for (int xIndex = x - 1; xIndex > 0; xIndex--) {
                beforeMatrix[yIndex][xIndex] =
                        afterMatrix[yIndex][xIndex] - afterMatrix[yIndex - 1][xIndex] - afterMatrix[yIndex][xIndex - 1]
                        + afterMatrix[yIndex - 1][xIndex - 1];
            }
            beforeMatrix[yIndex][0] = afterMatrix[yIndex][0] - afterMatrix[yIndex - 1][0];
        }

        for (int xIndex = x - 1; xIndex > 0; xIndex--) {
            beforeMatrix[0][xIndex] = afterMatrix[0][xIndex] - afterMatrix[0][xIndex - 1];
        }

        beforeMatrix[0][0] = afterMatrix[0][0];

        List<List<Integer>> before = new ArrayList<>();
        for (int yIndex = 0; yIndex < y; yIndex++) {
            List<Integer> temp = new ArrayList<>();
            for (int xIndex = 0; xIndex < x; xIndex++) {
//                System.out.println(beforeMatrix[yIndex][xIndex]);
                temp.add(beforeMatrix[yIndex][xIndex]);
            }
            before.add(temp);
        }
        return before;
    }
}

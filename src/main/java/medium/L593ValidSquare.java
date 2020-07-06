package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class L593ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] squares = new int[][]{p1, p2, p3, p4};
        HashSet<Integer> sizeCount = new HashSet<>();

        for (int i = 0; i < squares.length; i++) {
            for (int j = i + 1; j < squares.length; j++) {
                int[] point1 = squares[i];
                int[] point2 = squares[j];
                int lengthSquare = (point1[0] - point2[0]) * (point1[0] - point2[0]) + (point1[1] - point2[1]) * (point1[1] - point2[1]);
                sizeCount.add(lengthSquare);
            }
        }
        if (sizeCount.size() == 2) {
            List<Integer> temp = new ArrayList<>();
            for (int i : sizeCount) {
                temp.add(i);
            }
            if (temp.get(0) == 2 * temp.get(1) || 2 * temp.get(0) == temp.get(1)) {
                return true;
            }
        }
        return false;
    }
}

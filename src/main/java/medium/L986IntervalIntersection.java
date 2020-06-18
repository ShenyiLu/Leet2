package medium;

import java.util.ArrayList;
import java.util.List;

public class L986IntervalIntersection {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int indexA = 0;
        int indexB = 0;
        List<int[]> result = new ArrayList<>();

        while (indexA < A.length && indexB < B.length) {

            int startA = A[indexA][0];
            int endA = A[indexA][1];
            int startB = B[indexB][0];
            int endB = B[indexB][1];

            if (endA < startB) {
                indexA++;
            } else if (endB < startA) {
                indexB++;
            } else {
                int[] localInterval = new int[]{Math.max(startA, startB), Math.min(endA, endB)};
                result.add(localInterval);
                if (endA < endB) {
                    indexA++;
                } else {
                    indexB++;
                }
            }
        }
        int[][] resultArray = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }
}

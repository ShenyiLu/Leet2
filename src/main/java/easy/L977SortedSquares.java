package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L977SortedSquares {
    public int[] sortedSquares(int[] A) {
        List<Integer> negative = new ArrayList<>();
        List<Integer> nonNegative = new ArrayList<>();
        for (int a: A) {
            if (a >= 0) {
                nonNegative.add(a * a);
            } else {
                negative.add(a * a);
            }
        }
        Collections.reverse(negative);
        int index = 0;
        int negativeIndex = 0;
        int nonNegativeIndex = 0;
        while (index < A.length) {
            if (negativeIndex == negative.size()) {
                A[index] = nonNegative.get(nonNegativeIndex);
                nonNegativeIndex++;
            } else if (nonNegativeIndex == nonNegative.size()) {
                A[index] = negative.get(negativeIndex);
                negativeIndex++;
            } else {
                if (nonNegative.get(nonNegativeIndex) >= negative.get(negativeIndex)) {
                    A[index] = negative.get(negativeIndex);
                    negativeIndex++;
                } else {
                    A[index] = nonNegative.get(nonNegativeIndex);
                    nonNegativeIndex++;
                }
            }
            index++;
        }
        return A;
    }
}

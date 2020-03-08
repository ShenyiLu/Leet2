package helper;

import java.util.ArrayList;
import java.util.List;

public class Prime {
    public static int[] primeNumberGenerator(int start, int end) {
        List<Integer> primeNumberList = new ArrayList<>();
        populatePrimeNumberList(primeNumberList, end);

        int startIndex = 0;
        while (primeNumberList.get(startIndex) < start) {
            startIndex++;
        }

        int[] result = new int[primeNumberList.size() - startIndex];

        for (int i = startIndex; i < primeNumberList.size(); i++) {
            result[i - startIndex] = primeNumberList.get(i);
        }
        return result;
    }

    private static void populatePrimeNumberList(List<Integer> primeNumberList, int max) {
        if (max <= 1) {
            return;
        }
        primeNumberList.add(2);
        primeNumberList.add(3);
        int currentValue = 5;
        while (currentValue <= max) {
            boolean isPrime = true;
            for (int i = 0; primeNumberList.get(i) * primeNumberList.get(i) <= currentValue; i++) {
                if (currentValue % primeNumberList.get(i) == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeNumberList.add(currentValue);
            }
            currentValue += 2;
        }
    }

    public static int[][] primeFactor(int input, int[] primeNumberArray) {
        if (input < 4) {
            return null;
        }

        int factorMax = (int) Math.sqrt(input);

        if (factorMax > primeNumberArray[primeNumberArray.length - 1]) {
            primeNumberArray = primeNumberGenerator(0, (int) Math.sqrt(input));
        }

        List<Integer> factorHead = new ArrayList<>();
        List<Integer> factorTail = new ArrayList<>();

        int index = 0;
        while (index < primeNumberArray.length && primeNumberArray[index] <= factorMax) {
            int factor1 = primeNumberArray[index];
            if (input % factor1 == 0) {
                factorHead.add(factor1);
                factorTail.add(input / factor1);
            }
            index++;
        }

        int[][] result = new int[2][factorHead.size()];
        for (int i = 0; i < factorHead.size(); i++) {
            result[0][i] = factorHead.get(i);
            result[1][i] = factorTail.get(i);
        }
        return result;
    }
}

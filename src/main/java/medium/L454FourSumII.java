package medium;

import java.util.HashMap;

public class L454FourSumII {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i : A) {
            if (!countMap.containsKey(i)) {
                countMap.put(i, 1);
            } else {
                countMap.replace(i, 1 + countMap.get(i));
            }
        }
        countMap = calculate(countMap, B);
        int result = 0;
        for (int cValue : C) {
            for (int dValue : D) {
                int target = -1 * cValue * dValue;
                if (countMap.containsKey(target)) {
                    result += countMap.get(target);
                }
            }
        }

        return result;
    }

    private HashMap<Integer, Integer> calculate(HashMap<Integer, Integer> countMap, int[] input) {
        HashMap<Integer, Integer> temp = new HashMap<>();
        for (int i : input) {
            for (int key : countMap.keySet()) {
                int count = countMap.get(key);
                int sum = i + key;

                if (!temp.containsKey(sum)) {
                    temp.put(sum, count);
                } else {
                    temp.replace(sum, count + temp.get(sum));
                }
            }
        }
        return temp;
    }
}

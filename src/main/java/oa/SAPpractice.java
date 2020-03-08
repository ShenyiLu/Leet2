package oa;

import helper.Prime;

import java.util.*;

public class SAPpractice {
    // question: Bingo
    public int getBingo(int input) {
        if (input < 1 || input > 9999) {
            return -1;
        }

        boolean[] hit = new boolean[10];
        for (int i = 0; i < hit.length; i++) {
            hit[i] = false;
        }
        int round = 0;
        long sum = input;
        while (!allHit(hit)) {
            long temp = sum;
            while (temp > 0) {
                hit[(int) (temp % 10)] = true;
                temp = temp / 10;
            }
            round++;
            sum += input;
        }
        return round;
    }

    private boolean allHit(boolean[] hit) {
        for (int i = 0; i < hit.length; i++) {
            if(!hit[i]) {
                return false;
            }
        }
        return true;
    }

    // Question: Encoded message
    public String decodeMessage(int n, int[] list){
        List<Integer> arrayList = new ArrayList<>();
        for (int i : list) {
            arrayList.add(i);
        }
        return decodeMessage(n, arrayList);
    }

    public String decodeMessage(int n, List<Integer> list) {
        int[] primeArray = Prime.primeNumberGenerator(0, n);
        if (primeArray.length < 26) {
            return "";
        }

        // kinda like DFS
        int[][] primeFactorMatrix = Prime.primeFactor(list.get(0), primeArray);

        ArrayList<Integer> factorList = new ArrayList<>();
        for (int i = 0; i < primeFactorMatrix[0].length; i++) {
            if (dfsDecode(primeFactorMatrix[0][i], 0, list, factorList)) {
                return decode(factorList);
            }
            if (dfsDecode(primeFactorMatrix[1][i], 0, list, factorList)) {
                return decode(factorList);
            }
        }


        return "";
    }

    private boolean dfsDecode(int lastFactor, int index, List<Integer> list, ArrayList<Integer> factorList) {
        int current = list.get(index);
        if (current % lastFactor != 0) {
            return false;
        } else if (index == list.size() - 1) {
            factorList.add(lastFactor);
            factorList.add(current / lastFactor);
            return true;
        } else {
            boolean solved = dfsDecode(current / lastFactor, index + 1, list, factorList);
            if (solved) {
                factorList.add(0, lastFactor);
                return true;
            } else {
                return false;
            }
        }
    }

    private String decode(ArrayList<Integer> factorList)  {
        ArrayList<Integer> sortedList = new ArrayList<>(factorList);
        Collections.sort(sortedList);

        HashMap<Integer, Character> reference = new HashMap<>();
        char ch = 'A';
        for (int factor: sortedList) {
            reference.put(factor, ch);
            ch++;
        }
        StringBuilder builder = new StringBuilder();
        for (int factor: factorList) {
            builder.append(reference.get(factor));
        }
        return builder.toString();
    }
}

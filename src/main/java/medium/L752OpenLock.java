package medium;

import java.util.*;

public class L752OpenLock {
    public int openLock(String[] deadends, String target) {
        HashSet<String> begin = new HashSet<>();
        begin.add("0000");
        HashSet<String> end = new HashSet<>();
        end.add(target);
        HashSet<String> deadEnd = new HashSet<>(Arrays.asList(deadends));

        HashSet<String> temp;

        int forwardSteps = 0;

        while (!begin.isEmpty() && !end.isEmpty()) {
            if (begin.size() > end.size()) {
                temp = begin;
                begin = end;
                end = temp;
            }
            temp = new HashSet<>();
            for (String s : begin) {
                if (end.contains(s)) {
                    return forwardSteps;
                }
                if (deadEnd.contains(s)) {
                    continue;
                }
                deadEnd.add(s);
                temp.addAll(getNextStep(s, deadEnd));
            }
            forwardSteps++;
            begin = temp;
        }
        return -1;
    }

    private HashSet<String> getNextStep(String input, HashSet<String> visited) {
        int size = 4;
        int[] ints = new int[size];
        HashSet<String> result = new HashSet<>();
        for (int i = 0; i < size; i++) {
            ints[i] = input.charAt(i) - '0';
        }
        for (int i = 0; i < size; i++) {
            int temp = ints[i];
            ints[i] = (temp + 1) % 10;
            String str = toString(ints);
            if (!visited.contains(str)) {
                result.add(str);
            }
            ints[i] = (temp + 9) % 10;
            str = toString(ints);
            if (!visited.contains(str)) {
                result.add(str);
            }
            ints[i] = temp;
        }
        return result;
    }

    private String toString(int[] array) {
        StringBuilder builder = new StringBuilder();
        for (int i : array) {
            builder.append(i);
        }
        return builder.toString();
    }
}

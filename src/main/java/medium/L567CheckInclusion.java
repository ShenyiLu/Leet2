package medium;

import java.util.ArrayList;
import java.util.List;

public class L567CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        // calculate how many chars are there
        int[] s1Array = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            s1Array[c - 'a']++;
        }
        int s1Len = s1.length();

        List<String> possiblePermutations = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (s1Array[c - 'a'] == 0) {
                if (builder.length() >= s1Len) {
                    possiblePermutations.add(builder.toString());
                } else {
                    builder.setLength(0);
                }
            } else {
                builder.append(c);
            }
        }
        if (builder.length() >= s1Len) {
            possiblePermutations.add(builder.toString());
        }

        for (String candidate : possiblePermutations) {
            if (checkPermutation(candidate, s1Array, s1Len)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkPermutation(String candidate, int[] s1Array, int s1Len) {
        int[] candArray = new int[26];
        int head = 0;
        int tail = s1Len - 1;

        for (int i = head; i <= tail; i++) {
            candArray[candidate.charAt(i) - 'a']++;
        }
        boolean equal = true;
        for (int i = 0; i < candArray.length; i++) {
            if (candArray[i] != s1Array[i]) {
                equal = false;
                break;
            }
        }
        if (equal) {
            return true;
        }
        head++;
        tail++;
        while (tail < candidate.length()) {
            System.out.println(candidate.substring(head, tail + 1));
            int cHeadIndex = candidate.charAt(head - 1) - 'a';
            int cTailIndex = candidate.charAt(tail) - 'a';
            candArray[cHeadIndex]--;
            candArray[cTailIndex]++;
            equal = true;
            if ((candArray[cHeadIndex] == s1Array[cHeadIndex]) && (candArray[cTailIndex] == s1Array[cTailIndex])) {
                for (int i = 0; i < candArray.length; i++) {
                    if (candArray[i] != s1Array[i]) {
                        equal = false;
                        break;
                    }
                }
                if (equal) {
                    return true;
                }
            }
            head++;
            tail++;
        }
        return false;
    }
}

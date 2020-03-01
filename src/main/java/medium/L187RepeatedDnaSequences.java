package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class L187RepeatedDnaSequences {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (int i = 10; i <= s.length(); i++) {
            int head = i - 10;
            int tail = i;
            String str = s.substring(head, tail);
            int toNum = strToNum(str);
            if (!hashMap.containsKey(toNum)) {
                hashMap.put(toNum, 1);
            } else if (hashMap.get(toNum) == 1) {
                hashMap.replace(toNum, 2);
                result.add(str);
            }
        }
        return result;
    }

    private int strToNum(String str) {
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            result = result * 10 + charTransform(str.charAt(i));
        }
        return result;
    }

    private int charTransform(char c) {
        if (c == 'A') {
            return 1;
        }
        if (c == 'T') {
            return 2;
        }
        if (c == 'C') {
            return 3;
        }
        if (c == 'G') {
            return 4;
        }
        return 0;
    }
}

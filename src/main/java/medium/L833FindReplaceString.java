package medium;

import java.util.*;

public class L833FindReplaceString {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        if (indexes.length == 0) {
            return S;
        }

        HashMap<Integer, Integer> reference = new HashMap<>();
        // step 1 build reference map, sort indexes
        for (int i = 0; i < indexes.length; i++) {
            if (S.startsWith(sources[i], indexes[i])) {
                reference.put(indexes[i], i);
            }
        }

        // step 2 break S into substrings by indexes
        // and replace if sources match
        StringBuilder builder = new StringBuilder();
        int index = 0;
        while (index < S.length()) {
            if (reference.containsKey(index)) {
                builder.append(targets[reference.get(index)]);
                index += sources[reference.get(index)].length();
            } else {
                builder.append(S.charAt(index));
                index++;
            }
        }

        return builder.toString();
    }
}

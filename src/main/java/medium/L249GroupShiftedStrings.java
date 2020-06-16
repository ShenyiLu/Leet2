package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L249GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> groupByHash = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        for (String str : strings) {
            String hash = hash(str, builder);
            if (!groupByHash.containsKey(hash)) {
                groupByHash.put(hash, new ArrayList<>());
            }
            groupByHash.get(hash).add(str);
        }
        for (String key : groupByHash.keySet()) {
            List<String> temp = groupByHash.get(key);
            result.add(temp);
        }
        return result;
    }

    private String hash(String input, StringBuilder builder) {
        char[] chars = input.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            int distance = chars[i] - chars[i - 1];
            if (distance < 0) {
                distance += 26;
            }
            builder.append((char) ('a' + distance));
        }

        String result = builder.toString();
        builder.setLength(0);
        return result;
    }

}

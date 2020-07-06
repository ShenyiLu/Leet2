package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class L819MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String, Integer> wordMap = new HashMap<>();
        HashSet<String> bannedMap = new HashSet<>(Arrays.asList(banned));
        HashSet<Character> wordBreakMap = new HashSet<>(Arrays.asList('!', '?', '\'', ';', '.', ',', ' '));
        String result = "";
        int resultCount = 0;

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < paragraph.length(); i++) {
            char c = paragraph.charAt(i);
            if (c >= 'a' && c <= 'z') {
                builder.append(c);
                continue;
            }
            if (c >= 'A' && c <= 'Z') {
                builder.append((char) (c - 'A' + 'a'));
                continue;
            }
            if (wordBreakMap.contains(c) && builder.length() > 0) {
                String word = builder.toString();
                builder.setLength(0);
                if (!bannedMap.contains(word)) {
                    int count = 1 + wordMap.getOrDefault(word, 0);
                    wordMap.put(word, count);
                    if (count > resultCount) {
                        result = word;
                        resultCount = count;
                    }
                }

            }
        }
        if (builder.length() > 0) {
            String word = builder.toString();
            builder.setLength(0);
            if (!bannedMap.contains(word)) {
                int count = 1 + wordMap.getOrDefault(word, 0);
                wordMap.put(word, count);
                if (count > resultCount) {
                    result = word;
                    resultCount = count;
                }
            }
        }

        return result;
    }
}

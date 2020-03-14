package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class L243_245ShortestDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        HashMap<String, List<Integer>> wordMap = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            List<Integer> localList;
            if (wordMap.containsKey(s)) {
                localList = wordMap.get(s);
            } else {
                localList = new ArrayList<>();
            }
            localList.add(i);
            wordMap.put(s, localList);
        }

        if (word1.equals(word2)) {
            List<Integer> wordList = wordMap.get(word1);
            int head = 0;
            int tail = 1;
            int distance = Integer.MAX_VALUE;
            while (tail < wordList.size()) {
                distance = Math.min(distance, wordList.get(tail) - wordList.get(head));
                head++;
                tail++;
            }
            return distance;
        }

        List<Integer> word1List = wordMap.get(word1);
        List<Integer> word2List = wordMap.get(word2);
        int word1ListIndex = 0;
        int word2ListIndex = 0;
        int distance = Integer.MAX_VALUE;

        while (word1ListIndex < word1List.size() && word2ListIndex < word2List.size()) {
            int word1Index = word1List.get(word1ListIndex);
            int word2Index = word2List.get(word2ListIndex);

            distance = Math.min(distance, Math.abs(word1Index - word2Index));
            if (word1Index < word2Index) {
                word1ListIndex++;
            } else {
                word2ListIndex++;
            }
        }
        return distance;
    }
}

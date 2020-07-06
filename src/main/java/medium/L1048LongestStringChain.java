package medium;

import java.util.*;

public class L1048LongestStringChain {
    public int longestStrChain(String[] words) {
        if (words.length == 0) {
            return 0;
        }

        TreeMap<Integer, HashMap<String, Integer>> wordsCountMap = new TreeMap<>();
        for (String word: words) {
            HashMap<String, Integer> value = wordsCountMap.getOrDefault(word.length(), new HashMap<>());
            value.put(word, 1);
            wordsCountMap.put(word.length(), value);
        }
        System.out.println("keySet: " + wordsCountMap.keySet());
        for (HashMap<String, Integer> map:wordsCountMap.values()) {
            System.out.println(map.keySet());
        }

        Iterator<Integer> keySetIterator = wordsCountMap.keySet().iterator();
        int lastWordsLength = keySetIterator.next();
        HashMap<String, Integer> lastWordsMap = wordsCountMap.get(lastWordsLength);
        int maxChainSize = 1;

        while (keySetIterator.hasNext()) {
            int currentWordsLength = keySetIterator.next();
            HashMap<String, Integer> currentWordsMap = wordsCountMap.get(currentWordsLength);
            if (currentWordsLength - 1 == lastWordsLength) {
                for (Map.Entry<String, Integer> entry : currentWordsMap.entrySet()) {
                    String currentWord = entry.getKey();
                    int localChainSize = 1;
                    for (int i = 0; i < currentWord.length(); i++) {
                        String maybeLastWord = currentWord.substring(0, i) + currentWord.substring(i + 1);
                        localChainSize = Math.max(localChainSize, 1 + lastWordsMap.getOrDefault(maybeLastWord, 0));
                    }
                    currentWordsMap.replace(currentWord, localChainSize);
                    System.out.println("currentWord: " + currentWord + " localChainSize: " + localChainSize);
                    maxChainSize = Math.max(maxChainSize, localChainSize);
                }
            }
            lastWordsLength = currentWordsLength;
            lastWordsMap = currentWordsMap;
        }
        return maxChainSize;
    }
}

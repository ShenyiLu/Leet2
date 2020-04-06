package hard;

import java.util.*;

public class L472ConcatenatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        int shortest = Integer.MAX_VALUE;
        HashMap<Integer, HashSet<String>> bucketMap = new HashMap<>();
        // build data structure
        for (String word : words) {
            int length = word.length();
            if (length == 0) {
                continue;
            }

            shortest = Math.min(length, shortest);
            if (!bucketMap.containsKey(length)) {
                bucketMap.put(length, new HashSet<>());
            }
            bucketMap.get(length).add(word);
        }

        List<Integer> bucket = new ArrayList<>();
        bucket.addAll(bucketMap.keySet());
        Collections.sort(bucket);

        List<String> result = new ArrayList<>();
        if (bucket.size() == 0) {
            return result;
        }

        for (String word : words) {
            int length = word.length();
            // skip impossible cases
            if (length < 2 * shortest) {
                continue;
            }
            if (lookForConcatenated(word, shortest, bucketMap, bucket)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean lookForConcatenated(String word, int shortest, HashMap<Integer, HashSet<String>> bucketMap,
                                        List<Integer> bucket) {
        if (word.length() < shortest) {
            return false;
        }

        for (int wordLength : bucket) {
            if (wordLength > word.length() || (word.length() - wordLength) < shortest) {
                return false;
            }

            String word1 = word.substring(0, wordLength);
            int length1 = word1.length();
            String word2 = word.substring(wordLength);
            int length2 = word2.length();

            if (bucketMap.containsKey(length1) && bucketMap.get(length1).contains(word1)) {
                if ((bucketMap.containsKey(length2) && bucketMap.get(length2).contains(word2)) ||
                        lookForConcatenated(word2, shortest, bucketMap, bucket)) {
                    return true;
                }
            }
        }
        return false;
    }
}

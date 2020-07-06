package medium;

import java.util.*;

public class L692TopKFrequent {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String word : words) {
            if (!hashMap.containsKey(word)) {
                hashMap.put(word, 0);
            }
            hashMap.replace(word, hashMap.get(word) + 1);
        }
        PriorityQueue<WordWithFreq> priorityQueue = new PriorityQueue<>(k + 1, new WordWithFreqComparator());
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            WordWithFreq wwf = new WordWithFreq(entry.getKey(), entry.getValue());
            priorityQueue.offer(wwf);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        List<String> result = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            result.add(priorityQueue.poll().word);
        }
        Collections.reverse(result);
        return result;
    }

    class WordWithFreqComparator implements Comparator<WordWithFreq> {
        public int compare(WordWithFreq w1, WordWithFreq w2) {
            if (w1.freq == w2.freq) {
                return -(w1.word.compareTo(w2.word));
            }
            return w1.freq - w2.freq;
        }
    }

    class WordWithFreq {
        String word;
        int freq;

        public WordWithFreq(String w, int f) {
            word = w;
            freq = f;
        }
    }
}

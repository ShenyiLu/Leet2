package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L792MatchingSubseq {
    public int numMatchingSubseq(String S, String[] words) {
        int wordCount = 0;
        int[] charExistInS = new int[26];
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            charExistInS[ch - 'a']++;
        }


        HashMap<Character, List<String>> wordMap = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            char key = (char) ('a' + i);
            wordMap.put(key, new ArrayList<>());
        }
        for (String word : words) {
            if (existPossible(charExistInS, word)) {
                wordMap.get(word.charAt(0)).add(word);
            }
        }

        for (int i = 0; i < S.length(); i++) {
            char key = S.charAt(i);
            List<String> wordList = wordMap.get(key);
            List<String> newWordList = new ArrayList<>();
            for (String word : wordList) {
                if (word.length() == 1) {
                    wordCount++;
                    continue;
                }
                word = word.substring(1);
                char newKey = word.charAt(0);
                if (newKey == key) {
                    newWordList.add(word);
                } else {
                    wordMap.get(newKey).add(word);
                }
            }
            wordMap.replace(key, newWordList);
        }
        return wordCount;
    }

    private boolean existPossible(int[] charExistInS, String word) {
        int[] charExistInWord = new int[26];
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            charExistInWord[ch - 'a']++;
        }
        for (int i = 0; i < charExistInS.length; i++) {
            if (charExistInS[i] < charExistInWord[i]) {
                return false;
            }
        }
        return true;
    }
}

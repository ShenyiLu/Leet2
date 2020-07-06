package medium;

import java.util.ArrayList;
import java.util.List;

public class L809ExpressiveWords {
    public int expressiveWords(String S, String[] words) {
        List<Character> listSChar = new ArrayList<>();
        List<Integer> listSCharCount = new ArrayList<>();
        wordToList(S, listSChar, listSCharCount);

        int stretchyCount = 0;
        for (String word : words) {
            stretchyCount += isStretchy2(listSChar, listSCharCount, word) ? 1 : 0;
        }
        return stretchyCount;
    }

    private void wordToList(String S, List<Character> listChar, List<Integer> listCharCount) {
        int index = 0;
        while (index < S.length()) {
            char c = S.charAt(index);
            int count = 0;
            while (index + count < S.length() && S.charAt(index + count) == c) {
                count++;
            }
            listChar.add(c);
            listCharCount.add(count);
            index += count;
        }
    }

    private boolean isStretchy2(List<Character> listSChar, List<Integer> listSCharCount, String word) {
        int sIndex = 0;
        int wordIndex = 0;
        while (sIndex < listSChar.size() && wordIndex < word.length()) {
            char c = word.charAt(wordIndex);
            if (c != listSChar.get(sIndex)) {
                return false;
            }
            int count = 0;
            while (wordIndex + count < word.length() && word.charAt(wordIndex + count) == c) {
                count++;
            }

            int sCount = listSCharCount.get(sIndex);
            if (count > sCount || (sCount < 3 && count < sCount)) {
                return false;
            }

            sIndex++;
            wordIndex += count;
        }
        return sIndex == listSChar.size() && wordIndex == word.length();
    }

}

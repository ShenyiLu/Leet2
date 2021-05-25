package medium;

import java.util.ArrayList;
import java.util.List;

public class L1209RemoveDuplicates {
    public String removeDuplicates(String s, int k) {
        if (s.length() < k) {
            return s;
        }

        List<Character> characterList = new ArrayList<>();
        List<Integer> characterCount = new ArrayList<>();

        char[] chars = s.toCharArray();
        char currentChar = chars[0];
        int currentCount = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == currentChar) {
                currentCount++;
            } else {
                characterList.add(currentChar);
                characterCount.add(currentCount);
                currentChar = chars[i];
                currentCount = 1;
            }
        }
        characterList.add(currentChar);
        characterCount.add(currentCount);

        int removeCount = 0;
        StringBuilder builder = new StringBuilder();
        int length = characterList.size();
        for (int i = 0; i < length; i++) {
            if (characterCount.get(i) >= k) {
                removeCount++;
                characterCount.set(i, characterCount.get(i) % k);
            }
            for (int sequence = 0; sequence < characterCount.get(i); sequence++) {
                builder.append(characterList.get(i));
            }
        }
        String nextS = builder.toString();
        if (removeCount == 0) {
            return nextS;
        }
        return removeDuplicates(nextS, k);
    }
}

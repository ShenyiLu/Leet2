package hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class L340LengthOfLongestSubstringKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        HashMap<Character, Integer> characterCount = new HashMap<>();
        int head = 0;
        int tail = 0;
        int maxLength = 0;
        // init
        while (tail < s.length()) {
            char curr = s.charAt(tail);
            if (!characterCount.containsKey(curr)) {
                characterCount.put(curr, 1);
            } else {
                characterCount.replace(curr, characterCount.get(curr) + 1);
            }
            if (characterCount.keySet().size() <= k) {
                maxLength = Math.max(maxLength, tail - head + 1);
            } else {
                while (head <= tail && characterCount.keySet().size() > k) {
                    char headChar = s.charAt(head);
                    if (characterCount.get(headChar) == 1) {
                        characterCount.remove(headChar);
                    } else {
                        characterCount.replace(headChar, characterCount.get(headChar) - 1);
                    }
                    head++;
                }
            }
            tail++;
        }
        return maxLength;
    }


}

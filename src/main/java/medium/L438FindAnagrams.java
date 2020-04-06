package medium;

import java.util.ArrayList;
import java.util.List;

public class L438FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        int[] sArray = new int[26];
        for (int i = 0; i < p.length(); i++) {
            sArray[s.charAt(i) - 'a']++;
        }
        int removeCharIndex = 0;
        int addCharIndex = p.length();
        int[] pArray = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pArray[p.charAt(i) - 'a']++;
        }
        boolean equal = true;
        for (int i = 0; i < 26; i++) {
//            System.out.println("s: " + sArray[i] + " p: " + pArray[i]);
            if (sArray[i] != pArray[i]) {
                equal = false;
                break;
            }
        }
        while (addCharIndex < s.length()) {
            char removed = s.charAt(removeCharIndex);
            char added = s.charAt(addCharIndex);
            sArray[removed - 'a']--;
            sArray[added - 'a']++;
            if (equal) {
                result.add(removeCharIndex);
                if (removed != added) {
                    equal = false;
                }
            } else {
                if ((sArray[removed - 'a'] == pArray[removed - 'a']) &&
                        (sArray[added - 'a'] == pArray[added - 'a'])) {
                    equal = true;
                    for (int i = 0; i < 26; i++) {
                        if (sArray[i] != pArray[i]) {
                            equal = false;
                            break;
                        }
                    }
                }
            }

            removeCharIndex++;
            addCharIndex++;
        }
        if (equal) {
            result.add(removeCharIndex);
        }
        return result;
    }
}

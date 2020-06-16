package easy;

import java.util.HashMap;

public class L266canPermutePalindrome {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (!hashMap.containsKey(c)) {
                hashMap.put(c, 0);
            }
            hashMap.replace(c, hashMap.get(c) + 1);
        }

        int single = 0;
        for (int i : hashMap.values()) {
            single += i % 2;
        }
        return single <= 1;
    }
}

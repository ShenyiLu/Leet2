package easy;

import sun.plugin.javascript.navig.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class L345ReverseVowels {
    public String reverseVowels(String s) {
        if (s.length() == 1){
            return s;
        }
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        HashSet<Character> hash = new HashSet<>();
        for (char c: vowels) {
            hash.add(c);
        }
        ArrayList<Integer> vowelIndex = new ArrayList<>();
        char[] sChar = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hash.contains(c)){
                vowelIndex.add(i);
            }
            sChar[i] = c;
        }
        if (vowelIndex.size() <= 1) {
            return s;
        }

        int head = 0;
        int tail = vowelIndex.size() - 1;
        while (head < tail) {
            char c = sChar[vowelIndex.get(head)];
            sChar[vowelIndex.get(head)] = sChar[vowelIndex.get(tail)];
            sChar[vowelIndex.get(tail)] = c;
            head++;
            tail--;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(sChar);
        return builder.toString();
    }
}

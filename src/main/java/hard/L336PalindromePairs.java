package hard;

import java.util.*;

public class L336PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String, Integer> reverseWords = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            builder.append(s);
            builder.reverse();
            reverseWords.put(builder.toString(), i);
            builder.setLength(0);
        }

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() <= 0) {
                continue;
            }
            result.addAll(parseOneWord(i, words, reverseWords));
        }

        return result;
    }

    private List<List<Integer>> parseOneWord(int index, String[] words, HashMap<String, Integer> reverseWords) {
        String word = words[index];
        int length = word.length();
        List<List<Integer>> result = new ArrayList<>();

        // check if word itself is pad
        if (isPalindrome(word)) {
            int emptyIndex = reverseWords.getOrDefault("", -1);
            if (emptyIndex >= 0) {
                List<Integer> list1 = new ArrayList<>();
                list1.add(index);
                list1.add(emptyIndex);
                result.add(list1);
                List<Integer> list2 = new ArrayList<>();
                list2.add(emptyIndex);
                list2.add(index);
                result.add(list2);
            }
        }

        // check full word reverse
        int reverseIndex = reverseWords.getOrDefault(word, -1);
        if (reverseIndex >= 0 && reverseIndex != index) {
            List<Integer> list = new ArrayList<>();
            list.add(index);
            list.add(reverseIndex);
            result.add(list);
        }

        // check part word
        for (int k = 1; k < length; k++) {
            String part1 = word.substring(0, k);
            String part2 = word.substring(k);
            if (isPalindrome(part1)) {
                int partReverseIndex = reverseWords.getOrDefault(part2, -1);
                if (partReverseIndex >= 0 && partReverseIndex != index) {
                    List<Integer> list = new ArrayList<>();
                    list.add(partReverseIndex);
                    list.add(index);
                    result.add(list);
                }
            }

            if (isPalindrome(part2)) {
                int partReverseIndex = reverseWords.getOrDefault(part1, -1);
                if (partReverseIndex >= 0 && partReverseIndex != index) {
                    List<Integer> list = new ArrayList<>();
                    list.add(index);
                    list.add(partReverseIndex);
                    result.add(list);
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        int head = 0;
        int tail = s.length() - 1;
        while (head < tail) {
            if (s.charAt(head) != s.charAt(tail)) {
                return false;
            }
            head++;
            tail--;
        }
        return true;
    }
}

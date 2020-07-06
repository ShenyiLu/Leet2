package easy;

import java.util.*;

public class L953IsAlienSorted {
    public boolean isAlienSorted2(String[] words, String order) {
        char[] chars = new char[26];
        for (int i = 0; i < order.length(); i++) {
            chars[i] = order.charAt(i);
        }
        List<String> wordsTransformed = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                builder.append(chars[word.charAt(i) - 'a']);
            }
            wordsTransformed.add(builder.toString());
            builder.setLength(0);
        }

        List<String> wordsSorted = new ArrayList<>(wordsTransformed);
        Collections.sort(wordsSorted);
        return wordsTransformed.equals(wordsSorted);

    }

    public boolean isAlienSorted(String[] words, String order) {

        List<String> wordsList = new ArrayList<>(Arrays.asList(words));
        char[] orderArray = order.toCharArray();


        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                for (int i = 0; i < Math.min(o1.length(), o2.length()); i++) {
                    char c1 = o1.charAt(i);
                    char c2 = o2.charAt(i);
//                    if (orderArray[c1 - 'a'] != orderArray[c2 - 'a']) {
//                        return orderArray[c1 - 'a'] - orderArray[c2 - 'a'];
//                    }
                    System.out.println("case 1: " + orderArray[c1 - 'a'] + " " + orderArray[c2 - 'a']);
                    System.out.println("case 2: " + order.indexOf(c1) + " " + order.indexOf(c2));

                    if (order.indexOf(c1) != order.indexOf(c2)) {
                        return order.indexOf(c1) - order.indexOf(c2);
                    }
                }
                return o1.length() - o2.length();
            }
        };
        PriorityQueue<String> pq = new PriorityQueue<>(comparator);
        pq.addAll(wordsList);
        int index = 0;
        while (!pq.isEmpty()) {
            if (!pq.poll().equals(words[index++])) {
                return false;
            }
        }
        return true;

    }
}

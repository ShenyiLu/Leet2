package hard;

import java.util.HashMap;

public class L76MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        HashMap<Character, Integer> tMap = new HashMap<>();
        char[] tCharArray = t.toCharArray();
        for (char c : tCharArray) {
            if (!tMap.containsKey(c)) {
                tMap.put(c, 0);
            }
            tMap.replace(c, 1 + tMap.get(c));
        }
        int head = 0;
        while (!tMap.containsKey(s.charAt(head))) {
            head++;
            if (head == s.length()) {
                return "";
            }
        }


        int tCharSatisfied = 0;
        String result = "";
        int tail = head;

        HashMap<Character, Integer> sMap = new HashMap<>();
        for (int i = tail; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!tMap.containsKey(c)) {
                continue;
            }
            if (!sMap.containsKey(c)) {
                sMap.put(c, 0);
            }
            sMap.replace(c, 1 + sMap.get(c));
            if (sMap.get(c) <= tMap.get(c)) {
                tCharSatisfied++;
            }
            if (tCharSatisfied == t.length()) {
                while (head < s.length()) {
                    char remove = s.charAt(head);
                    if (!tMap.containsKey(remove)) {
                        head++;
                        continue;
                    }
                    if (sMap.get(remove) <= tMap.get(remove)) {
                        break;
                    }
                    sMap.replace(remove, sMap.get(remove) - 1);
                    head++;
                }

                String target = s.substring(head, i + 1);
                if (result.length() == 0 || result.length() > target.length()) {
                    result = target;
                }

                char remove = s.charAt(head);
                sMap.replace(remove, sMap.get(remove) - 1);
                head++;
                tCharSatisfied--;
            }
        }
        return result;
    }
}

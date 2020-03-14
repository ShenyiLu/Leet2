package easy;

import java.util.ArrayList;
import java.util.List;

public class L696CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        if (s.length() <= 1) {
            return 0;
        }
        List<Integer> count = new ArrayList<>();
        int index = 0;
        char currChar = s.charAt(0);
        int currCount = 0;
        while (index < s.length()) {
            while (index < s.length() && s.charAt(index) == currChar) {
                currCount++;
                index++;
            }
            if (index < s.length()) {
                currChar = s.charAt(index);
            }
            count.add(currCount);
            currCount = 0;
        }
        if (count.size() <= 1) {
            return 0;
        }
        int listIndex = 1;
        int strCount = 0;
        while (listIndex < count.size()) {
            strCount += Math.min(count.get(listIndex - 1), count.get(listIndex));
            listIndex++;
        }
        return strCount;
    }
}

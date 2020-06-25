package easy;

import java.util.ArrayList;
import java.util.List;

public class L293FlipGame {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<>();
        if (!s.contains("++")) {
            return result;
        }
        int head = 0;
        int tail = 1;
        while (tail < s.length()) {
            if (s.charAt(head) == '+' && s.charAt(tail) == '+') {
                String temp = s.substring(0, head) + "--";
                if (tail < s.length() - 1) {
                    temp += s.substring(tail + 1);
                }
                result.add(temp);
            }
            head++;
            tail++;
        }
        return result;
    }
}

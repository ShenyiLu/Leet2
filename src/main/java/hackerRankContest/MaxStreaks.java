package hackerRankContest;

import java.util.ArrayList;
import java.util.List;

public class MaxStreaks {
    public static List<Integer> getMaxStreaks(List<String> toss) {
        // Return an array of two integers containing the maximum streak of heads and tails respectively
        int maxHeads = 0;
        int maxTails = 0;
        int index = 0;
        while (index < toss.size()) {
            String currToss = toss.get(index);
            int currStreak = 1;
            index++;
            while (index < toss.size() && toss.get(index).equals(currToss)) {
                currStreak++;
                index++;
            }
            if (currToss.equals("Heads")) {
                maxHeads = Math.max(maxHeads, currStreak);
            } else {
                maxTails = Math.max(maxTails, currStreak);
            }
        }
        List<Integer> result = new ArrayList<>();
        result.add(maxHeads);
        result.add(maxTails);
        return result;
    }
}

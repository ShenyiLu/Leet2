package medium;

import java.util.*;

public class L1010NumPairsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] time) {
        int sum = 0;
        HashMap<Integer, List<Integer>> timeMap = new HashMap<>();
        for (int i = 0; i < time.length; i++) {
            time[i] = time[i] % 60;
            timeMap.putIfAbsent(time[i], new ArrayList<>());
            timeMap.get(time[i]).add(i);
        }
        Set<Integer> checkedTime = new HashSet<>();
        for (int halftime : timeMap.keySet()) {
            int halftime2 = (60 - halftime) % 60;
            if (!timeMap.containsKey(halftime2) || checkedTime.contains(halftime2)) {
                continue;
            }
            if (halftime == halftime2) {
                int size = timeMap.get(halftime).size() - 1;
                sum += (1 + size) * size / 2;
            } else {
                int size1 = timeMap.get(halftime).size();
                int size2 = timeMap.get(halftime2).size();
                sum += size1 * size2;
            }
            checkedTime.add(halftime);
            checkedTime.add(halftime2);
        }
        return sum;
    }
}

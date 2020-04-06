package medium;

import java.util.HashMap;
import java.util.Map;

public class L494FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1);

        for (int num : nums) {
            Map<Integer, Integer> next = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                int v = entry.getKey();
                int count = entry.getValue();

                next.put(v + num, next.getOrDefault(v + num, 0) + count);
                next.put(v - num, next.getOrDefault(v - num, 0) + count);
            }
            countMap = next;
        }
        return countMap.getOrDefault(S, 0);
    }
}

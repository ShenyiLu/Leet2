package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L347TopKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> countElement = new HashMap<>();
        for (int num: nums) {
            if (!countElement.containsKey(num)) {
                countElement.put(num,1);
            } else {
                countElement.replace(num, countElement.get(num) + 1);
            }
        }
        List<Integer>[] barrel = new List[nums.length + 1];
        for (int key: countElement.keySet()) {
            int val = countElement.get(key);
            if (barrel[val] == null) {
                barrel[val] = new ArrayList<>();
            }
            barrel[val].add(key);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = barrel.length - 1; i >= 0; i--) {
            if (barrel[i] == null) {
                continue;
            }
            List<Integer> bar = barrel[i];
            for (int val: bar) {
                if (k >= 0) {
                    result.add(val);
                    k--;
                } else {
                    return result;
                }
            }
        }
        return result;
    }
}

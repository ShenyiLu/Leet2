package hard;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class L239MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int head = 0;
        int tail = k - 1;
        TreeMap<Integer, Integer> window = new TreeMap<>();
        List<Integer> max = new ArrayList<>();
        for (int i = head; i <= tail; i++) {
            int num = nums[i];
            if (!window.containsKey(num)) {
                window.put(num, 0);
            }
            window.replace(num, window.get(num) + 1);
        }
        max.add(window.lastKey());
        head++;
        tail++;

        while (tail < nums.length) {
            int headVal = nums[head];
            int tailVal = nums[tail];

            if (window.get(headVal) > 1) {
                window.replace(headVal, window.get(headVal) - 1);
            } else {
                window.remove(headVal);
            }

            if (!window.containsKey(tailVal)) {
                window.put(tailVal, 0);
            }
            window.replace(tailVal, 1 + window.get(tailVal));

            max.add(window.lastKey());
            head++;
            tail++;
        }
        int[] result = new int[max.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = max.get(i);
        }
        return result;
    }
}

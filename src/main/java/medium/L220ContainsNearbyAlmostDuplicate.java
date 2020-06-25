package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class L220ContainsNearbyAlmostDuplicate {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length <= 1) {
            return false;
        }
        if (k == 0) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (hashMap.containsKey(num)) {
                    int j = hashMap.get(num);
                    if (Math.abs(i - j) <= k) {
                        return true;
                    }
                }
                hashMap.put(num, i);
            }
            return false;
        }


        int head = 0;
        int tail = Math.min(k, nums.length) - 1;
        TreeMap<Integer, Integer> window = new TreeMap<>();
        for (int i = head; i <= tail; i++) {
            int num = nums[i];

            if (window.keySet().size() >= 1 && check(window, num, t)) {
                return true;
            }

            if (!window.containsKey(num)) {
                window.put(num, 0);
            }
            window.replace(num, window.get(num) + 1);
        }
        tail++;

        while (tail < nums.length) {

            int headVal = nums[head];
            int tailVal = nums[tail];

            if (check(window, tailVal, t)) {
                return true;
            }

            if (window.get(headVal) > 1) {
                window.replace(headVal, window.get(headVal) - 1);
            } else {
                window.remove(headVal);
            }

            if (!window.containsKey(tailVal)) {
                window.put(tailVal, 0);
            }
            window.replace(tailVal, 1 + window.get(tailVal));
            head++;
            tail++;
        }
        return false;
    }

    private boolean check(TreeMap<Integer, Integer> window, int num, int t) {
        if (window.ceilingKey(num) != null && Math.abs((long)num - (long)window.ceilingKey(num)) <= t) {
            return true;
        }
        if (window.floorKey(num) != null && Math.abs((long)num - (long)window.floorKey(num)) <= t) {
            return true;
        }
        return false;
    }
}

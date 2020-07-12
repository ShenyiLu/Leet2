package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class L846IsNStraightHand {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand == null || hand.length < W) {
            return false;
        }
        TreeMap<Integer, Integer> countMap = new TreeMap<>();
        int totalCards = 0;
        for (int i : hand) {
            countMap.putIfAbsent(i, 0);
            countMap.put(i, 1 + countMap.get(i));
            totalCards++;
        }
        if (countMap.keySet().size() < W || totalCards % W != 0) {
            return false;
        }

        List<Integer> keys = new ArrayList<>(countMap.keySet());
        List<Integer> vals = new ArrayList<>(countMap.values());
        int head = 0;

        while (head < keys.size()) {
            int nextHead = -1;
            int headKey = keys.get(head);
            int headVal = vals.get(head);

            for (int i = head; i < head + W; i++) {
                if ((keys.get(i) - headKey) != i - head || vals.get(i) < headVal) {
                    return false;
                }
                vals.set(i, vals.get(i) - headVal);
                if (nextHead == -1 && vals.get(i) > 0) {
                    nextHead = i;
                }
            }
            head = nextHead == -1 ? head + W : nextHead;
        }

        return true;
    }
}

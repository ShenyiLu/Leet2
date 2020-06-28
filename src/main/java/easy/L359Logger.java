package easy;

import java.util.*;

public class L359Logger {

    private int[] buckets;
    private Set[] sets;

    /**
     * Initialize your data structure here.
     */
    public L359Logger() {
        int size = 10;
        buckets = new int[size];
        sets = new Set[size];
        for (int i = 0; i < size; i++) {
            sets[i] = new HashSet<String>();
        }
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     * If this method returns false, the message will not be printed.
     * The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        int index = timestamp % 10;
        if (timestamp != buckets[index]) {
            sets[index].clear();
            buckets[index] = timestamp;
        }

        for (int i = 0; i < buckets.length; i++) {
            if (timestamp - buckets[i] < 10 && sets[i].contains(message)) {
                return false;
            }
        }
        sets[index].add(message);
        return true;
    }
}

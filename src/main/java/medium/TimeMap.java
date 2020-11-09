package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap {
    HashMap<String, TreeMap<Integer, String>> timeMap;

    /**
     * Initialize your data structure here.
     */
    public TimeMap() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timeMap.putIfAbsent(key, new TreeMap<>());
        timeMap.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) {
            return "";
        }
        TreeMap<Integer, String> valMap = timeMap.get(key);
        Map.Entry<Integer, String> entry = valMap.floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
}
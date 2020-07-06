package medium;

import java.util.*;

public class MyCalendar {
    TreeMap<Integer, Integer> calendar;

    public MyCalendar() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> ceiling = calendar.ceilingEntry(start);
        Map.Entry<Integer, Integer> floor = calendar.floorEntry(start);
        if (ceiling != null && ceiling.getKey() < end) {
            return false;
        }
        if (floor != null && start < floor.getValue()) {
            return false;
        }
        calendar.put(start, end);
        return true;
    }
}

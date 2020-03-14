package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class L252MeetingRoom {
    public boolean canAttendMeetings(int[][] intervals) {
        ArrayList<Integer> startTimeList = new ArrayList<>();
        HashMap<Integer, Integer> intervalMap = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < intervals.length; i++) {
            startTimeList.add(intervals[i][0]);
            intervalMap.put(intervals[i][0], intervals[i][1]);
        }

        Collections.sort(startTimeList);
        if (startTimeList.size() <= 1) {
            return true;
        }
        int head = 0;
        int tail = 1;
        while (tail < startTimeList.size()) {
            if (intervalMap.get(startTimeList.get(head)) > startTimeList.get(tail)) {
                return false;
            }
            head++;
            tail++;
        }
        return true;
    }
}

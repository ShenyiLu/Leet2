package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class L253MeetingRoom {
    public int minMeetingRooms(int[][] intervals) {
        ArrayList<Integer> startTimeList = new ArrayList<>();
        HashMap<Integer, PriorityQueue<Integer>> intervalMap = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < intervals.length; i++) {

            int startTime = intervals[i][0];
            int endTime = intervals[i][1];

            startTimeList.add(startTime);
            PriorityQueue<Integer> duplicateEndTime = new PriorityQueue<>();
            if (intervalMap.containsKey(intervals[i][0])) {
                duplicateEndTime = intervalMap.get(intervals[i][0]);
            }
            duplicateEndTime.add(endTime);
            intervalMap.put(intervals[i][0], duplicateEndTime);
        }

        Collections.sort(startTimeList);
        if (startTimeList.size() == 0) {
            return 0;
        }
        if (startTimeList.size() == 1) {
            return 1;
        }

        int head = 0;

        while (head < startTimeList.size()) {
            int currStartTime = startTimeList.get(head);
            int currEndTime = intervalMap.get(startTimeList.get(head)).poll();
            if (!minHeap.isEmpty() && minHeap.peek() <= currStartTime) {
                minHeap.poll();
            }
            minHeap.add(currEndTime);

            head++;
        }
        return minHeap.size();
    }
}

package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class L739DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        HashMap<Integer, PriorityQueue<Integer>> tempDateMap = new HashMap<>();
        for (int date = 0; date < T.length; date++) {
            tempDateMap.putIfAbsent(T[date], new PriorityQueue<>());
            tempDateMap.get(T[date]).offer(date);
        }
        for (int date = 0; date < T.length; date++) {
            int temperature = T[date];
            int nextDate = Integer.MAX_VALUE;
            for (int t = temperature + 1; t <= 100; t++) {
                PriorityQueue<Integer> pq = tempDateMap.getOrDefault(t, null);
                if (pq == null) {
                    continue;
                }
                while (!pq.isEmpty() && pq.peek() <= date) {
                    pq.poll();
                }
                if (pq.isEmpty()) {
                    continue;
                }
                nextDate = Math.min(nextDate, pq.peek());
            }

            result[date] = (nextDate == Integer.MAX_VALUE ? 0 : nextDate - date);
        }
        return result;
    }
}

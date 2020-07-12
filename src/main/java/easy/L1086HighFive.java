package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class L1086HighFive {
    public int[][] highFive(int[][] items) {
        TreeMap<Integer, PriorityQueue<Integer>> treeMap = new TreeMap<>();
        for (int[] item : items) {
            int id = item[0];
            int score = item[1];
            treeMap.putIfAbsent(id, new PriorityQueue<>());
            PriorityQueue<Integer> pq = treeMap.get(id);

            if (pq.size() < 5) {
                pq.offer(score);
                continue;
            }

            if (score > pq.peek()) {
                pq.poll();
                pq.offer(score);
            }
        }
        int[][] result = new int[treeMap.keySet().size()][2];
        int index = 0;
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : treeMap.entrySet()) {
            int avg = 0;
            int id = entry.getKey();
            PriorityQueue<Integer> pq = entry.getValue();
            while (pq.size() > 0) {
                avg += pq.poll();
            }
            avg /= 5;
            result[index][0] = id;
            result[index][1] = avg;
            index++;
        }
        return result;
    }


}

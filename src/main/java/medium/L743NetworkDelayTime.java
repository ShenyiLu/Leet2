package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class L743NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {
        HashMap<Integer, HashMap<Integer, Integer>> timesMap = new HashMap<>();
        for (int[] time : times) {
            timesMap.putIfAbsent(time[0], new HashMap<>());
            timesMap.get(time[0]).put(time[1], time[2]);
        }

        // priority Queue
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        priorityQueue.add(new int[]{0, K});
        boolean[] visited = new boolean[1 + N];
        int result = 0;

        while (!priorityQueue.isEmpty()) {
            int[] current = priorityQueue.poll();
            int currentNode = current[1];
            int currentDist = current[0];
            if (visited[currentNode]) {
                continue;
            }
            visited[currentNode] = true;
            result = currentDist;
            N--;
            if (timesMap.containsKey(currentNode)) {
                for (Map.Entry<Integer, Integer> entry : timesMap.get(currentNode).entrySet()) {
                    priorityQueue.add(new int[]{currentDist + entry.getValue(), entry.getKey()});
                }
            }
        }

        return N == 0 ? result : -1;
    }
}

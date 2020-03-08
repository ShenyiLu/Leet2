package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L207CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 0 = not checked, 1 = checking, 2 = safe
        int[] visited = new int[numCourses];
        HashMap<Integer, List<Integer>> prereq = new HashMap<>();
        for (int[] i : prerequisites) {
            int key = i[0];
            int val = i[1];
            if (prereq.containsKey(key)) {
                prereq.get(key).add(val);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(val);
                prereq.put(key, list);
            }
        }

        // DFS
        for (int key : prereq.keySet()) {
            if (!dfs(visited, prereq, key)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[] visited, HashMap<Integer, List<Integer>> prereq, int key) {
        if (visited[key] == 2) {
            return true;
        }
        if (visited[key] == 1) {
            return false;
        }

        visited[key] = 1;
        if (!prereq.containsKey(key)) {
            visited[key] = 2;
            return true;
        }

        List<Integer> valList = prereq.get(key);
        for (int val: valList) {
            if (!dfs(visited, prereq, val)) {
                return false;
            }
        }
        visited[key] = 2;
        return true;
    }
}

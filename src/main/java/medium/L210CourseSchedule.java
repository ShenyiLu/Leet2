package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L210CourseSchedule {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 0 = not checked, 1 = checking, 2 = safe
        int[] visited = new int[numCourses];

        List<Integer> tempRes = new ArrayList<>();
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
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(visited, prereq, i, tempRes)) {
                return new int[0];
            }
        }

        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = tempRes.get(i);
        }
        return result;
    }

    private boolean dfs(int[] visited, HashMap<Integer, List<Integer>> prereq, int key, List<Integer> temp) {
        if (visited[key] == 2) {
            return true;
        }
        if (visited[key] == 1) {
            return false;
        }

        visited[key] = 1;
        if (!prereq.containsKey(key)) {
            visited[key] = 2;
            temp.add(key);
            return true;
        }

        List<Integer> valList = prereq.get(key);
        for (int val: valList) {
            if (!dfs(visited, prereq, val, temp)) {
                return false;
            }
        }
        visited[key] = 2;
        temp.add(key);
        return true;
    }
}

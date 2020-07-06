package medium;

import java.util.*;

public class L939MinimumAreaRectangle {
    public int minAreaRect(int[][] points) {
        HashMap<Integer, HashSet<Integer>> xAxes = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> yAxes = new HashMap<>();
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            xAxes.putIfAbsent(x, new HashSet<>());
            xAxes.get(x).add(y);
            yAxes.putIfAbsent(y, new HashSet<>());
            yAxes.get(y).add(x);
        }
        removeSinglePoints(xAxes);
        removeSinglePoints(yAxes);
        int minSize = Integer.MAX_VALUE;

        for (Map.Entry<Integer, HashSet<Integer>> entry : xAxes.entrySet()) {
            int x1 = entry.getKey();
            List<Integer> ys = new ArrayList<>(entry.getValue());
            for (int i = 0; i < ys.size() - 1; i++) {
                for (int j = i + 1; j < ys.size(); j++) {
                    int y1 = ys.get(i);
                    int y2 = ys.get(j);
                    if (!yAxes.containsKey(y1) || !yAxes.containsKey(y2)) {
                        continue;
                    }
                    if (!(yAxes.get(y1).contains(x1) && yAxes.get(y2).contains(x1))) {
                        continue;
                    }
                    // now we have 3 sides, check if 4th side exist
                    HashSet<Integer> xShort = yAxes.get(y1);
                    HashSet<Integer> xLong = yAxes.get(y2);
                    if (xShort.size() > xLong.size()) {
                        HashSet<Integer> temp = xShort;
                        xShort = xLong;
                        xLong = temp;
                    }
                    for (int x2 : xShort) {
                        if (xLong.contains(x2) && x1 != x2) {
                            minSize = Math.min(minSize, Math.abs((x1 - x2) * (y1 - y2)));
                        }
                    }
                }
            }
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }

    private void removeSinglePoints(HashMap<Integer, HashSet<Integer>> axes) {
        List<Integer> removeList = new ArrayList<>();
        for (Map.Entry<Integer, HashSet<Integer>> entry : axes.entrySet()) {
            if (entry.getValue().size() < 2) {
                removeList.add(entry.getKey());
            }
        }
        for (int key : removeList) {
            axes.remove(key);
        }
    }
}

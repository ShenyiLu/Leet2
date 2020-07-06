package medium;

import java.util.LinkedList;
import java.util.Queue;

public class L994RottingOranges {
    private int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // -1: in queue
    public int orangesRotting(int[][] grid) {
        if (grid.length == 1 && grid[0].length == 1 && grid[0][0] == 0) {
            return 0;
        }

        Queue<int[]> bfs = new LinkedList<>();
        int badOrangeCount = 0;
        int goodOrangeCount = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                if (grid[x][y] == 2) {
                    badOrangeCount++;
                }
                if (grid[x][y] == 1) {
                    goodOrangeCount++;
                    int status = status(x, y, grid);
                    if (status == 0) {
                        return -1;
                    }
                    if (status == 2) {
                        grid[x][y] = -1;
                        bfs.offer(new int[]{x, y});
                    }
                }
            }
        }

        if (badOrangeCount == 0) {
            return -1;
        }

        int minute = 0;

        while (bfs.size() > 0) {
            minute++;
            int size = bfs.size();
            while (size > 0) {
                int[] location = bfs.poll();
                int x = location[0];
                int y = location[1];

                grid[x][y] = 2;
                goodOrangeCount--;

                for (int[] direction : directions) {
                    int x1 = x + direction[0];
                    int y1 = y + direction[1];
                    if (isInGrid(x1, y1, grid) && grid[x1][y1] == 1) {
                        grid[x1][y1] = -1;
                        bfs.offer(new int[]{x1, y1});
                    }
                }
                size--;
            }
        }
        return goodOrangeCount != 0 ? -1 : minute;
    }

    // status 0: no orange around status 1: fresh orange around; status 2: bad orange around
    private int status(int x, int y, int[][] grid) {
        int result = 0;
        for (int[] direction : directions) {
            int x1 = x + direction[0];
            int y1 = y + direction[1];
            if (isInGrid(x1, y1, grid)) {
                if (grid[x1][y1] == 2) {
                    return 2;
                }
                if (grid[x1][y1] == 1 || grid[x1][y1] == -1) {
                    result = 1;
                }
            }
        }
        return result;
    }

    private boolean isInGrid(int x, int y, int[][] grid) {
        if (y < 0 || y >= grid[0].length || x < 0 || x >= grid.length) {
            return false;
        }
        return true;
    }
}

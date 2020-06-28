package medium;

import java.util.LinkedList;
import java.util.Queue;

public class L934ShortestBridge {

    // state: 0 is sea, -1 is island A, 1 is island B, -2 is inQueue
    public int shortestBridge(int[][] A) {
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int height = A.length;
        int width = A[0].length;
        Queue<int[]> bfsQueue = new LinkedList<>();

        // look for and mark island A
        boolean found = false;
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                if (A[x][y] == 1) {
                    dfsFindIsland1(x, y, A, directions, bfsQueue);
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        // look for island B
        return bfsFindIsland2(bfsQueue, directions, A);
    }

    private int bfsFindIsland2(Queue<int[]> bfsQueue, int[][] directions, int[][] A) {
        int range = 1;
        while (!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();
            while (size > 0) {
                int[] index = bfsQueue.poll();
                int x = index[0];
                int y = index[1];

                for (int[] direction : directions) {
                    int x1 = x + direction[0];
                    int y1 = y + direction[1];
                    if (isNotInMatrix(x1, y1, A) || A[x1][y1] < 0) {
                        continue;
                    }
//                    System.out.println("X1: " + x1 + " Y1: " + y1);
                    if (A[x1][y1] == 1) {
                        return range;
                    }
                    A[x1][y1] = -2;
                    bfsQueue.offer(new int[]{x1, y1});
                }
                size--;
            }
            range++;
        }
        return 0;
    }

    private void dfsFindIsland1(int x, int y, int[][] A, int[][] directions, Queue<int[]> bfsQueue) {
        if (isNotInMatrix(x, y, A) || A[x][y] < 0) {
            return;
        }
        if (A[x][y] == 0) {
            bfsQueue.offer(new int[]{x, y});
            A[x][y] = -2;
            return;
        }

        A[x][y] = -1;
        for (int[] direction : directions) {
            int x1 = x + direction[0];
            int y1 = y + direction[1];
            dfsFindIsland1(x1, y1, A, directions, bfsQueue);
        }
    }

    private boolean isNotInMatrix(int x, int y, int[][] A) {
        return x < 0 || x >= A.length || y < 0 || y >= A[0].length;
    }
}

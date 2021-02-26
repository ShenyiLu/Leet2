package medium;

import java.util.HashMap;

public class L1041RobotBound {
    public boolean isRobotBounded(String instructions) {
        /**
         * Direction:
         * North: 0
         * South: 1
         * West: 2
         * East: 3
         *
         * North-L-West: 0-L-2
         * North-R-East 0-R-3
         * South-L-East: 1-L-3
         * South-R-West: 1-R-2
         * West-L-South: 2-L-1
         * West-R-North: 2-R-0
         * East-L-North: 3-L-0
         * East-R-South: 3-R-1
         */
        int currentDirection = 0;
        int[] currentLocation = new int[]{0, 0};
        char[][] nextDirection = new char[][]{{2, 3}, {3, 2}, {1, 0}, {0, 1}};
        int[][] nextLocation = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        for (char ch : instructions.toCharArray()) {
            if (ch == 'L') {
                currentDirection = nextDirection[currentDirection][0];
            } else if (ch == 'R') {
                currentDirection = nextDirection[currentDirection][1];
            } else {
                currentLocation[0] += nextLocation[currentDirection][0];
                currentLocation[1] += nextLocation[currentDirection][1];
            }
        }
        return currentDirection != 0 || (currentLocation[0] == 0 && currentLocation[1] == 0);
    }
}

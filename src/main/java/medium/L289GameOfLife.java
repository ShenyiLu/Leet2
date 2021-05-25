package medium;

public class L289GameOfLife {
    private int[][] directions = {{-1, -1}, {0, -1}, {1, -1},
            {-1, 0}, {1, 0}, {-1, 1}, {0, 1}, {1, 1}};
    private static int isDead = 0;
    private static int isLive = 1;
    private static int isLiveWillDie = 2;
    private static int isDeadWillLive = 3;

    public void gameOfLife(int[][] board) {
        /**
         * State:
         * 0: dead
         * 1: live
         * 2: is live, will be dead
         * 3: is dead, will be live
         */
        int maxWidth = board.length;
        int maxHeight = board[0].length;
        for (int width = 0; width < maxWidth; width++) {
            for (int height = 0; height < maxHeight; height++) {
                int currentState = board[width][height];
                int liveNeighbors = countLiveNeighbors(width, height, board);
                if (currentState == isDead && liveNeighbors == 3) {
                    board[width][height] = isDeadWillLive;
                }
                if (currentState == isLive && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[width][height] = isLiveWillDie;
                }

            }
        }
        for (int width = 0; width < maxWidth; width++) {
            for (int height = 0; height < maxHeight; height++) {
                board[width][height] %= 2;
            }
        }
    }

    private boolean onBoard(int width, int height, int[][] board) {
        int maxWidth = board.length;
        int maxHeight = board[0].length;
        return (width >= 0 && width < maxWidth) && (height >= 0 && height < maxHeight);
    }

    private int countLiveNeighbors(int width, int height, int[][] board) {
        int liveNeighbors = 0;
        for (int[] direction : directions) {
            int neighborWidth = width + direction[0];
            int neighborHeight = height + direction[1];
            if (onBoard(neighborWidth, neighborHeight, board) &&
                    (board[neighborWidth][neighborHeight] == isLive ||
                            board[neighborWidth][neighborHeight] == isLiveWillDie)) {
                liveNeighbors++;
            }
        }
        return liveNeighbors;
    }
}

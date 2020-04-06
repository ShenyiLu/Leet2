package medium;

public class L419CountBattleships {
    public int countBattleships(char[][] board) {
        int count = 0;
        if (board.length == 0 || board[0].length == 0) {
            return count;
        }

        for (int height = 0; height < board.length; height++) {
            for (int width = 0; width < board[0].length; width++) {
                if (board[height][width] == '.') {
                    continue;
                }
                count++;
                wipe(height, width, board);
            }
        }
        return count;
    }

    private void wipe(int height, int width, char[][] board) {
        board[height][width] = '.';
        int h = height - 1;
        int w = width;
        while (h >= 0 && board[h][w] == 'X') {
            board[h][w] = '.';
            h--;
        }
        h = height + 1;
        while (h < board.length && board[h][w] == 'X') {
            board[h][w] = '.';
            h++;
        }
        h = height;
        w = width - 1;
        while (w >= 0 && board[h][w] == 'X') {
            board[h][w] = '.';
            w--;
        }
        w = width + 1;
        while (w < board[0].length && board[h][w] == 'X') {
            board[h][w] = '.';
            w++;
        }
    }
}

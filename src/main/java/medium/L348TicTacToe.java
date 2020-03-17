package medium;

public class L348TicTacToe {
    int[][] chessBoard;
    int[] vertical;
    int[] horizontal;
    int leftSlide;
    int rightSlide;
    boolean hasWinner;
    int winner;

    public L348TicTacToe(int n) {
        init(n);
    }

    private void init(int n) {
        chessBoard = new int[n][n];
        vertical = new int[n];
        horizontal = new int[n];
        leftSlide = 0;
        rightSlide = 0;
        hasWinner = false;
        winner = 0;
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        if (hasWinner) {
            return winner;
        }

        int n = vertical.length;
        chessBoard[row][col] = player;
        vertical[row]++;
        horizontal[col]++;
        if (row == col) {
            leftSlide++;
        }
        if (row + col + 1 == n) {
            rightSlide++;
        }
        if (vertical[row] == n || horizontal[col] == n || leftSlide == n || rightSlide == n) {
            int tempWinner = checkWinner(row, col, player);
            if (tempWinner != 0) {
                hasWinner = true;
                winner = tempWinner;
                return winner;
            }
        }
        return 0;
    }

    private int checkWinner(int row, int col, int player) {
        int n = vertical.length;
        boolean win = true;
        // check row
        for (int i = 0; i < n; i++) {
            if (chessBoard[row][i] != player) {
                win = false;
                break;
            }
        }
        if (win) {
//            System.out.println("row");
//            printChessBoard();
            return player;
        }
        win = true;

        // check col
        for (int i = 0; i < n; i++) {
            if (chessBoard[i][col] != player) {
                win = false;
                break;
            }
        }
        if (win) {
//            System.out.println("col");
//            printChessBoard();
            return player;
        }
        win = true;

        // check slide
        if (row == col) {
            for (int i = 0; i < n; i++) {
                if (chessBoard[i][i] != player) {
                    win = false;
                    break;
                }

            }
            if (win) {
//                System.out.println("left");
//                printChessBoard();
                return player;
            }
            win = true;
        }


        if (row + col + 1 == n) {
            for (int i = 0; i < n; i++) {
                if (chessBoard[n-1-i][i] != player) {
                    win = false;
                    break;
                }
            }
            if (win) {
//                System.out.println("right");
//                printChessBoard();
                return player;
            }
            win = true;
        }

        return 0;
    }

    private void printChessBoard() {
        int n = chessBoard.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(chessBoard[i][j]);
            }
            System.out.println();
        }
    }
}

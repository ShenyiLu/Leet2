package medium;

public class L36ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        int[] check = new int[10];
        // check row
        for (int height = 0; height < board.length; height++) {
            for (int width = 0; width < board[0].length; width++) {
                char c = board[height][width];
                initCheck(c, check);
            }
            if (!validateCheck(check)) {
                return false;
            }
            resetCheck(check);
        }

        // check column
        for (int width = 0; width < board[0].length; width++) {
            for (int height = 0; height < board.length; height++) {
                char c = board[height][width];
                initCheck(c, check);
            }
            if (!validateCheck(check)) {
                return false;
            }
            resetCheck(check);
        }

        // check sub-box
        for (int height = 0; height < board.length; height += 3) {
            for (int width = 0; width < board[0].length; width += 3) {
                for (int subHeight = height; subHeight < height + 3; subHeight++) {
                    for (int subWidth = width; subWidth < width + 3; subWidth++) {
                        char c = board[subHeight][subWidth];
                        initCheck(c, check);
                    }

                }
                if (!validateCheck(check)) {
                    return false;
                }
                resetCheck(check);
            }
        }

        return true;
    }

    private void initCheck(char c, int[] check) {
        if (c >= '1' && c <= '9') {
            check[c - '1'] += 1;
        }
    }

    private void resetCheck(int[] check) {
        for (int i = 0; i < check.length; i++) {
            check[i] = 0;
        }
    }

    private boolean validateCheck(int[] check) {
        for (int i = 0; i < check.length; i++) {
            if (check[i] > 1) {
                return false;
            }
        }
        return true;
    }
}

package hackerRankContest;

public class DetermineTheWinner {
    public static String getRoundResult(char winning_suit, char suit1, int number1, char suit2, int number2) {
        // Write your code here
        final String PLAYER_1_WIN = "Player 1 wins";
        final String PLAYER_2_WIN = "Player 2 wins";
        final String DRAW = "Draw";

        if ((suit1 == winning_suit && suit2 == winning_suit) || (suit1 != winning_suit && suit2 != winning_suit)) {
            if (number1 > number2) {
                return PLAYER_1_WIN;
            } else if (number1 < number2) {
                return PLAYER_2_WIN;
            } else {
                return DRAW;
            }
        }

        if (suit1 == winning_suit) {
            return PLAYER_1_WIN;
        }
        return PLAYER_2_WIN;

    }
}

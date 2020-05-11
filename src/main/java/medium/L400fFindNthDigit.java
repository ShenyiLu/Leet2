package medium;

public class L400fFindNthDigit {

    public int findNthDigit(int n) {
        int numberSize = 1;
        long numberCount = 9;
        int start = 1;

        while (n > numberSize * numberCount) {
            n -= numberSize * numberCount;
            numberSize += 1;
            numberCount *= 10;
            start *= 10;
        }

        start += (n - 1) / numberSize;
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % numberSize));
    }
}

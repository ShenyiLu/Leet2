package easy;

public class L171TitleToNumber {
    public int titleToNumber(String s) {
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int index = s.length() - 1 - i;
            sum += Math.pow(26, index) * charToNumber(s.charAt(i));
        }
        return sum;
    }

    private int charToNumber(char c) {
        return (int)(c - 'A' + 1);
    }
}

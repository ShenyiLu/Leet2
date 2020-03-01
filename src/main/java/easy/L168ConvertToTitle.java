package easy;

public class L168ConvertToTitle {
    public String convertToTitle(int n) {
        StringBuilder builder = new StringBuilder();
        while (n > 26) {
            if (n % 26 == 0) {
                builder.append("Z");
                n = (n - 26) / 26;
            } else {
                builder.append(numToChar(n % 26));
                n = n / 26;
            }

        }
        builder.append(numToChar(n));
        return builder.reverse().toString();
    }

    private char numToChar(int num) {
        return (char) ('A' - 1 + num);
    }
}

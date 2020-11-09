package medium;

public class L647CountPalindromicSubstrings {
    public int countSubstrings(String s) {
        int count = 0;
        char[] charSub = s.toCharArray();
        for (int index = 0; index < charSub.length; index++) {
            count += oddPad(index, charSub);
            count += evenPad(index, charSub);
        }
        return count;
    }

    private int oddPad(int index, char[] charSub) {
        int count = 1;
        int head = index - 1;
        int tail = index + 1;
        while (head >= 0 && tail < charSub.length) {
            if (charSub[head] == charSub[tail]) {
                count++;
                head--;
                tail++;
            } else {
                break;
            }
        }
        return count;
    }

    private int evenPad(int index, char[] charSub) {
        int count = 0;
        int head = index;
        int tail = index + 1;
        while (head >= 0 && tail < charSub.length) {
            if (charSub[head] == charSub[tail]) {
                count++;
                head--;
                tail++;
            } else {
                break;
            }
        }
        return count;
    }

}

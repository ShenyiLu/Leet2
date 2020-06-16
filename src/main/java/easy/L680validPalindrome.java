package easy;

public class L680validPalindrome {
    public boolean validPalindrome(String s) {
        return validPalindrome(s, false);
    }

    private boolean validPalindrome(String s, boolean deleteFound) {
        int head = 0;
        int tail = s.length() - 1;
        while (head < tail) {
            if (s.charAt(head) != s.charAt(tail)) {
                if (deleteFound) {
                    return false;
                }
                return validPalindrome(s.substring(head, tail), true) ||
                        validPalindrome(s.substring(head + 1, tail + 1), true);
            }

            head++;
            tail--;
        }
        return true;
    }
}

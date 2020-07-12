package easy;

public class L125IsPalindrome {
    public boolean isPalindrome(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') || c >= '0' && c <= '9') {
                builder.append(c);
            } else if (c >= 'A' && c <= 'Z') {
                builder.append((char)(c - ('A' - 'a')));
            }
        }
        s = builder.toString();
        if (s.length() == 0) {
            return true;
        }

        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (ci != cj) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

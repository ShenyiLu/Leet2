package medium;

public class L1249minRemoveToMakeValid {
    public String minRemoveToMakeValid(String s) {
        s = remove('(', ')', s);

        return remove(')', '(', s);

    }

    private String remove(char left, char right, String s) {
        int parenthesesCount = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == right && parenthesesCount == 0) {
                continue;
            }
            if (c == left) {
                parenthesesCount++;
            }
            if (c == right) {
                parenthesesCount--;
            }
            builder.append(c);
        }
        return builder.reverse().toString();
    }


}

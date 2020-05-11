package medium;

import java.util.Stack;

public class L402RemoveKDigits {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        if (num.length() == k) {
            return "0";
        }
        if (k == 0) {
            return num;
        }

        // phase 1: remove decending parts
        int index = 0;
        while (index < num.length()) {
            char c = num.charAt(index);

            while (k > 0 && !stack.isEmpty() && c < stack.peek()) {
                k--;
                stack.pop();
            }
            stack.push(c);
            index++;
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        builder.reverse();

        // phase 2 delete starting 0's
        while (builder.length() > 0 && builder.charAt(0) == '0') {
            builder.deleteCharAt(0);
        }

        if (builder.length() == 0) {
            return "0";
        }
        return builder.toString();
    }
}

package medium;

import java.util.Stack;

public class L227Calculate {
    public int calculate(String s) {
        // get rid of blank
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                builder.append(s.charAt(i));
            }
        }
        s = builder.toString();


        Stack<Integer> number = new Stack<>();
        int currentNum = 0;
        char currentOp = '+';
        int index = 0;
        while (index < s.length() && isNumber(s.charAt(index))) {
            currentNum = currentNum * 10 + (s.charAt(index) - '0');
            index++;
        }
        if (index == s.length()) {
            return currentNum;
        }

        currentOp = s.charAt(index);
        number.add(currentNum);
        currentNum = 0;
        index++;
        while (index < s.length()) {
            while (index < s.length() && isNumber(s.charAt(index))) {
                currentNum = currentNum * 10 + (s.charAt(index) - '0');
                index++;
            }
            if (currentOp == '+') {
                number.add(currentNum);
            } else if (currentOp == '-') {
                number.add(0 - currentNum);
            } else  if (currentOp == '*') {
                int last = number.pop();
                number.add(last * currentNum);
            } else {
                int last = number.pop();
                number.add(last / currentNum);
            }
            if (index < s.length()) {
                currentOp = s.charAt(index++);
            }
            currentNum = 0;
        }

        int result = 0;
        while (!number.isEmpty()) {
            result += number.pop();
        }
        return result;

    }

    private boolean isNumber (char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }

}

package hard;

import java.util.Stack;

public class L224Calculator {
    public int calculate(String s) {
        s += " ";
        int currentLevelResult = 0;
        int currentNumber = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                currentNumber = currentNumber * 10 + (int) (ch - '0');
            } else {
                currentLevelResult += currentNumber * sign;
                if (ch == '(') {
                    stack.push(currentLevelResult);
                    stack.push(sign);
                    currentLevelResult = 0;
                } else if (ch == ')') {
                    currentLevelResult *= stack.pop();
                    currentLevelResult += stack.pop();
                }
                currentNumber = 0;
                sign = (ch == '-') ? -1 : 1;
            }
        }
        return currentLevelResult;
    }


}

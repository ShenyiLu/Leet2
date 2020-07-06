package medium;

import java.util.Stack;

public class L946ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) {
            return false;
        }
        if (pushed.length == 0) {
            return true;
        }

        int pushedIndex = 0;
        int poppedIndex = 0;
        Stack<Integer> stack = new Stack<>();
        while (pushedIndex < pushed.length || poppedIndex < popped.length) {
            if (stack.isEmpty() || stack.peek() != popped[poppedIndex]) {
                if (pushedIndex > pushed.length) {
                    return false;
                }
                stack.push(pushed[pushedIndex]);
                pushedIndex++;
            } else {
                if (poppedIndex > popped.length) {
                    return false;
                }
                stack.pop();
                poppedIndex++;
            }
        }
        return stack.isEmpty();
    }
}

package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L379PhoneDirectory {
    boolean[] numbers;
    int lastAssigned;
    Stack<Integer> released;

    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public L379PhoneDirectory(int maxNumbers) {
        // true: can be assigned
        // false: already assigned
        numbers = new boolean[maxNumbers];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = true;
        }

        lastAssigned = -1;
        released = new Stack<>();
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (released.size() > 0) {
            int result = released.pop();
            numbers[result] = false;
            return result;
        }
        lastAssigned += 1;
        if (lastAssigned >= numbers.length) {
            return -1;
        }
        numbers[lastAssigned] = false;
        return lastAssigned;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        if (number < 0 || number >= numbers.length) {
            return false;
        }
        return numbers[number];
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (number < 0 || number >= numbers.length) {
            return;
        }
        if (!numbers[number]) {
            released.add(number);
        }
        numbers[number] = true;
    }
}

package medium;

import java.util.Stack;

public class L456find132pattern {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        int secondLargest = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < secondLargest) {
                return true;
            }
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                secondLargest = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }
}

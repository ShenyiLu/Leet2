package easy;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> tailStack;
    Stack<Integer> headStack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        tailStack = new Stack<>();
        headStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        tailStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (headStack.isEmpty()) {
            while (!tailStack.isEmpty()) {
                headStack.push(tailStack.pop());
            }
        }
        return headStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (headStack.isEmpty()) {
            while (!tailStack.isEmpty()) {
                headStack.push(tailStack.pop());
            }
        }
        return headStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return tailStack.isEmpty() && headStack.isEmpty();
    }
}

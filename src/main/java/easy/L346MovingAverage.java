package easy;

import java.util.LinkedList;
import java.util.Queue;

public class L346MovingAverage {
    private Queue<Double> queue;
    private int currentSize;
    private int maxSize;
    private double sum;

    /**
     * Initialize your data structure here.
     */
    public L346MovingAverage(int size) {
        queue = new LinkedList<>();
        currentSize = 0;
        maxSize = size;
        sum = 0;
    }

    public double next(int val) {
        queue.offer((double) val);
        sum += val;
        if (currentSize < maxSize) {
            currentSize++;
        } else {
            double dequeue = queue.poll();
            sum -= dequeue;
        }
        return sum / currentSize;
    }
}

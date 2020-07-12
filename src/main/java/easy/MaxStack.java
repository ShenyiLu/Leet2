package easy;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class MaxStack {
    private LinkedList<Element> linkedList;
    private PriorityQueue<Element> priorityQueue;
    private int seq;

    /**
     * initialize your data structure here.
     */
    public MaxStack() {
        linkedList = new LinkedList<>();
        priorityQueue = new PriorityQueue<>(new Comparator<Element>() {
            @Override
            public int compare(Element o1, Element o2) {
                if (o1.val == o2.val) {
                    return o2.index - o1.index;
                }
                return o2.val - o1.val;
            }
        });
        seq = 0;
    }

    public void push(int x) {
        Element e = new Element(x, seq++);
        linkedList.add(e);
        priorityQueue.offer(e);
    }

    public int pop() {
        Element e = linkedList.pollLast();
        priorityQueue.remove(e);
        return e.val;
    }

    public int top() {
        return linkedList.peekLast().val;
    }

    public int peekMax() {
        return priorityQueue.peek().val;
    }

    public int popMax() {
        Element e = priorityQueue.poll();
        linkedList.remove(e);
        return e.val;
    }

    class Element {
        int val;
        int index;

        public Element(int v, int i) {
            val = v;
            index = i;
        }
    }
}

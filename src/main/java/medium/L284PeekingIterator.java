package medium;

import java.util.Iterator;

public class L284PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iter;
    private Integer next = null;

    public L284PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iter = iterator;
        if (this.iter.hasNext()) {
            next = this.iter.next();
        }

    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int result = next;
        if (iter.hasNext()) {
            next = iter.next();
        } else {
            next = null;
        }

        return result;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}
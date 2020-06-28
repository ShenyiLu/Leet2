package medium;

import helper.NestedInteger;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class L341NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> nestedIntegerStack;

    public L341NestedIterator(List<NestedInteger> nestedList) {
        nestedIntegerStack = new Stack<>();
        prepareStack(nestedList);
    }

    private void prepareStack(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            nestedIntegerStack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        return nestedIntegerStack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!nestedIntegerStack.isEmpty() && !nestedIntegerStack.peek().isInteger()) {
            List<NestedInteger> temp = nestedIntegerStack.pop().getList();
            prepareStack(temp);
        }
        return !nestedIntegerStack.isEmpty();
    }
}

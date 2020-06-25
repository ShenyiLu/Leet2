package easy;

import helper.NestedInteger;

import java.util.List;

public class L339DepthSum {
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }

    private int depthSum(List<NestedInteger> nestedList, int currDepth) {
        int sum = 0;
        for (NestedInteger nested : nestedList) {
            if (nested.isInteger()) {
                sum += nested.getInteger() * currDepth;
            } else {
                sum += depthSum(nested.getList(), currDepth + 1);
            }
        }
        return sum;
    }
}

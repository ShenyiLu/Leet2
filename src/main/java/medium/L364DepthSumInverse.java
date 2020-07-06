package medium;

import helper.NestedInteger;

import java.util.List;

public class L364DepthSumInverse {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int maxDepth = findMaxDepth(nestedList);
        return depthSum(nestedList, 1, maxDepth);
    }

    private int findMaxDepth(List<NestedInteger> nestedList) {
        int maxDepth = 0;
        for (NestedInteger nested : nestedList) {
            if (nested.isInteger()) {
                maxDepth = Math.max(maxDepth, 1);
            } else {
                maxDepth = Math.max(maxDepth, 1 + findMaxDepth(nested.getList()));
            }
        }
        return maxDepth;
    }

    private int depthSum(List<NestedInteger> nestedList, int currDepth, int maxDepth) {
        int sum = 0;
        for (NestedInteger nested : nestedList) {
            if (nested.isInteger()) {
                sum += nested.getInteger() * (maxDepth - currDepth + 1);
            } else {
                sum += depthSum(nested.getList(), currDepth + 1, maxDepth);
            }
        }
        return sum;
    }
}

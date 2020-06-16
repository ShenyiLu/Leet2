package easy;

import helper.TreeNode;

public class L938RangeSumBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        long sum = rangeSum(root, L, R);
        return (int)sum;
    }

    private long rangeSum(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }

        long val = 0;
        if (root.val >= L && root.val <= R) {
            val = root.val;
        }

        return rangeSum(root.left, L , R) + val + rangeSum(root.right, L, R);
    }
}

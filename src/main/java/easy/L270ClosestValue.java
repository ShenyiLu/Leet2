package easy;

import helper.TreeNode;

public class L270ClosestValue {
    public int closestValue(TreeNode root, double target) {
        if (root.left == null && root.right == null) {
            return root.val;
        }

        int childCloset;
        if (root.left == null) {
            childCloset = closestValue(root.right, target);
        } else if (root.right == null) {
            childCloset = closestValue(root.left, target);
        } else {
            int leftCloset = closestValue(root.left, target);
            int rightCloset = closestValue(root.right, target);

            if (Math.abs(leftCloset - target) < Math.abs(rightCloset - target)) {
                childCloset = leftCloset;
            } else {
                childCloset = rightCloset;
            }
        }

        if (Math.abs(childCloset - target) < Math.abs(root.val - target)) {
            return childCloset;
        } else {
            return root.val;
        }
    }
}

package easy;

import helper.TreeNode;

public class L543DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root)[0];
    }

    // 0: diameter 1 depth
    public int[] diameter(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] leftDiameter = diameter(root.left);
        int[] rightDiameter = diameter(root.right);
        int leftDepth = leftDiameter[1];
        int rightDepth = rightDiameter[1];
        int diameter = Math.max(Math.max(leftDiameter[0], rightDiameter[0]), leftDepth + rightDepth);
        return new int[]{diameter, Math.max(leftDepth, rightDepth)};
    }
}

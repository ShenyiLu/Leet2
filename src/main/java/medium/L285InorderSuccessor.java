package medium;

import helper.TreeNode;

public class L285InorderSuccessor {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        int rootVal = root.val;
        int pVal = p.val;
        if (rootVal == pVal) {
            return root.right;
        }
        if (rootVal > pVal) {
            TreeNode left = inorderSuccessor(root.left, p);
            return (left != null) ? left : root;
        }

        return inorderSuccessor(root.right, p);
    }
}

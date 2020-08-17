package easy;

import helper.TreeNode;

public class L617MergeTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return subMergeTrees(t1, t2);
    }

    private TreeNode subMergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode newNode;
        if (t1 == null && t2 == null) {
            return null;
        } else if (t1 == null) {
            newNode = new TreeNode(t2.val);
        } else if (t2 == null) {
            newNode = new TreeNode(t1.val);
        } else {
            newNode = new TreeNode(t1.val + t2.val);
        }
        newNode.left = subMergeTrees(getLeft(t1), getLeft(t2));
        newNode.right = subMergeTrees(getRight(t1), getRight(t2));
        return newNode;
    }

    private TreeNode getLeft(TreeNode t) {
        if (t == null) {
            return null;
        }
        return t.left;
    }

    private TreeNode getRight(TreeNode t) {
        if (t == null) {
            return null;
        }
        return t.right;
    }
}

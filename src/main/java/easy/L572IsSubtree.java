package easy;

import helper.TreeNode;

public class L572IsSubtree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        return findT(s, t);
    }

    private boolean findT(TreeNode sNode, TreeNode t) {
        if (sNode == null) {
            return false;
        }
        if (sNode.val == t.val) {
            if (checkSubTree(sNode, t)) {
                return true;
            }
        }
        return findT(sNode.left, t) || findT(sNode.right, t);
    }

    private boolean checkSubTree(TreeNode sSub, TreeNode tSub) {
        if (sSub == null && tSub == null) {
            return true;
        }
        if (sSub == null || tSub == null) {
            return false;
        }

        if (sSub.val == tSub.val) {
            return checkSubTree(sSub.left, tSub.left) && checkSubTree(sSub.right, tSub.right);
        }
        return false;
    }
}

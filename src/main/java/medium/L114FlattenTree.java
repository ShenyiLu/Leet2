package medium;

import helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class L114FlattenTree {
    public void flatten(TreeNode root) {
        flat(root);
    }

    private List<TreeNode> flat(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<TreeNode> listLeft = flat(root.left);
        List<TreeNode> listRight = flat(root.right);
        root.left = null;
        List<TreeNode> result = new ArrayList<>();
        if (listLeft == null && listRight == null) {
            result.add(root);
            return result;
        } else if (listLeft == null) {
            root.right = listRight.get(0);
            result.add(root);
            result.add(listRight.get(listRight.size() - 1));
            return result;
        } else if (listRight == null) {
            root.right = listLeft.get(0);
            result.add(root);
            result.add(listLeft.get(listLeft.size() - 1));
            return result;
        } else {
            root.right = listLeft.get(0);
            result.add(root);
            listLeft.get(listLeft.size() - 1).right = listRight.get(0);
            result.add(listRight.get(listRight.size() - 1));
            return result;
        }
    }
}

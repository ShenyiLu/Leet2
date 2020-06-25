package medium;

import helper.TreeNode;

import java.util.HashMap;

public class L865SubtreeWithAllDeepest {
    HashMap<TreeNode, Integer> depthMap = new HashMap<>();

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        if (leftDepth == rightDepth) {
            return root;
        }
        return leftDepth > rightDepth ? subtreeWithAllDeepest(root.left) : subtreeWithAllDeepest(root.right);

    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (depthMap.containsKey(root)) {
            return depthMap.get(root);
        }
        int maxDepth = Math.max(depth(root.left), depth(root.right)) + 1;
        depthMap.put(root, maxDepth);
        return maxDepth;
    }
}

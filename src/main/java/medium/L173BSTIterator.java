package medium;

import helper.TreeNode;

import java.util.Stack;

public class L173BSTIterator {
    Stack<TreeNode> nodeStack;
    public L173BSTIterator(TreeNode root) {
        TreeNode current = root;
        nodeStack = new Stack<>();
        while (current != null) {
            nodeStack.push(current);
            current = current.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode result = nodeStack.pop();
        if (result.right != null) {
            // incorrect
            TreeNode current = result.right;
            while (current != null) {
                nodeStack.push(current);
                current = current.left;
            }
        }
        return result.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !nodeStack.isEmpty();
    }
}

package medium;

import helper.TreeNode;

import java.util.TreeSet;

public class L230KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet = findSmallest(root, k, treeSet);
        return treeSet.last();
    }

    public TreeSet<Integer> findSmallest(TreeNode root, int k, TreeSet<Integer> treeSet) {
        if (root == null) {
            return treeSet;
        }
        findSmallest(root.left, k, treeSet);
        if (treeSet.size() >= k) {
            return treeSet;
        }
        treeSet.add(root.val);
        if (treeSet.size() >= k) {
            return treeSet;
        }
        findSmallest(root.right, k, treeSet);
        return treeSet;

    }
}

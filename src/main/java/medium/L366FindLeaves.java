package medium;

import helper.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class L366FindLeaves {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        findRangeToLeave(root, treeMap);

        for (List<Integer> res : treeMap.values()) {
            result.add(res);
        }
        return result;
    }

    private int findRangeToLeave(TreeNode root, TreeMap<Integer, List<Integer>> treeMap) {
        int range;
        if (root.left == null && root.right == null) {
            range = 0;
        } else if (root.left == null) {
            range = 1 + findRangeToLeave(root.right, treeMap);
        } else if (root.right == null) {
            range = 1 + findRangeToLeave(root.left, treeMap);
        } else {
            range = 1 + Math.max(findRangeToLeave(root.left, treeMap), findRangeToLeave(root.right, treeMap));
        }

        if (!treeMap.containsKey(range)) {
            treeMap.put(range, new ArrayList<>());
        }
        treeMap.get(range).add(root.val);
        return range;
    }
}

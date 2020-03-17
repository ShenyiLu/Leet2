package medium;

import helper.TreeNode;

import java.util.*;

public class L314VerticalOrder {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        HashMap<TreeNode, Integer> rangeMap = new HashMap<>();
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        Queue<TreeNode> queue = new LinkedList<>();

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        calculateRange(root, 0, rangeMap);
        queue.add(root);
        bfs(queue, 1, rangeMap, treeMap);
        for (int key : treeMap.keySet()) {
            result.add(treeMap.get(key));
        }
        return result;
    }

    private void bfs(Queue<TreeNode> queue, int levelSize, HashMap<TreeNode, Integer> rangeMap, TreeMap<Integer, List<Integer>> treeMap) {
        if (levelSize == 0) {
            return;
        }
        int nextSize = 0;
        int currSize = 0;
        while (currSize < levelSize) {
            TreeNode currNode = queue.poll();
            // TODO
            int nodeRange = rangeMap.get(currNode);
            if (!treeMap.containsKey(nodeRange)) {
                treeMap.put(nodeRange, new ArrayList<>());
            }
            treeMap.get(nodeRange).add(currNode.val);

            if (currNode.left != null) {
                queue.add(currNode.left);
                nextSize++;
            }
            if (currNode.right != null) {
                queue.add(currNode.right);
                nextSize++;
            }
            currSize++;
        }
        if (nextSize == 0) {
            return;
        }
        bfs(queue, nextSize, rangeMap, treeMap);
    }

    private void calculateRange(TreeNode root, int currRange, HashMap<TreeNode, Integer> rangeMap) {
        if (root == null) {
            return;
        }
        rangeMap.put(root, currRange);
        calculateRange(root.left, currRange - 1, rangeMap);
        calculateRange(root.right, currRange + 1, rangeMap);
    }
}

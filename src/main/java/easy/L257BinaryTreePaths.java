package easy;

import helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class L257BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root, result, new StringBuilder());
        return result;
    }

    public void dfs(TreeNode root, List<String> result, StringBuilder builder) {
        if (root == null) {
            return;
        }
        String temp = "" + root.val;

        if (root.left == null && root.right == null) {
            builder.append(temp);
            result.add(builder.toString());
        } else {
            temp += "->";
            builder.append(temp);
            dfs(root.left, result, builder);
            dfs(root.right, result, builder);
        }
        builder.delete(builder.length() - temp.length(), builder.length());
        return;
    }
}

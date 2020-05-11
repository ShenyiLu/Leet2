package medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L46Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int length = nums.length;

        boolean[] used = new boolean[length];
        for (int i = 0; i < length; i++) {
            used[i] = false;
        }
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, used, list, length, result);
        return result;
    }

    private void dfs(int[] nums, boolean[] used, List<Integer> list, int length, List<List<Integer>> result) {
        if (list.size() == length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (used[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            list.add(nums[i]);
            dfs(nums, used, list, length, result);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}

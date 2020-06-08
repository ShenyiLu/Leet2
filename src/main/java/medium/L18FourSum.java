package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L18FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }
        sortNums(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int currentTarget = target - nums[i] - nums[j];
                int start = j + 1;
                int end = nums.length - 1;
                while (start < end) {
                    if (nums[start] + nums[end] == currentTarget) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[start]);
                        temp.add(nums[end]);
                        result.add(temp);
                        int tempStartEnd = nums[start];
                        while (start < end && nums[start] == tempStartEnd) {
                            start++;
                        }
                        tempStartEnd = nums[end];
                        while (start < end && nums[end] == tempStartEnd) {
                            end--;
                        }
                        continue;
                    }

                    if (nums[start] + nums[end] < currentTarget) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return result;
    }

    private void sortNums(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        for (int num : nums) {
            temp.add(num);
        }
        Collections.sort(temp);
        for (int i = 0; i < temp.size(); i++) {
            nums[i] = temp.get(i);
        }
        temp.clear();
    }
}

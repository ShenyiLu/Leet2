package medium;

import java.util.HashMap;

public class L523CheckSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        // [0, 0], 0 is true
        // [0, 0], 1 is true
        // [1, 2], 0 is false
        if (nums.length < 2) {
            return false;
        }
        if (nums.length == 2) {
            if (k != 0) {
                return (nums[0] + nums[1]) % k == 0;
            }
            return (nums[0] + nums[1]) == k;
        }

        int sum = 0;
        HashMap<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                sum %= k;
            }
            Integer getInt = remainderMap.get(sum);
            if (getInt != null) {
                if (i - getInt > 1) {
                    return true;
                }

            } else {
                remainderMap.put(sum, i);
            }
        }
        return false;
    }
}

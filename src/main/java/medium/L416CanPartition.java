package medium;

import java.util.Arrays;

public class L416CanPartition {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 1) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }

        sum /= 2;
        int n = nums.length;
        boolean[] dp = new boolean[sum + 1];
        Arrays.fill(dp, false);
        dp[0] = true;

        for (int num : nums) {
            for (int i = sum; i > 0; i--) {
                if (i >= num) {
                    dp[i] = dp[i] || dp[i - num];
                }
                if (dp[sum]) {
                    return true;
                }
            }

        }
        return dp[sum];
    }
}

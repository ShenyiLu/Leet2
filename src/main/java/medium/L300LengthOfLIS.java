package medium;

public class L300LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int currentNum = nums[i];
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < currentNum) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }


}

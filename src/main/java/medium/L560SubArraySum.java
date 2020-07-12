package medium;

public class L560SubArraySum {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int[] sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 1; i < sums.length; i++) {
            sums[i] = nums[i - 1] + sums[i - 1];
        }
        for (int i = 1; i < sums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (sums[i] + k == sums[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}

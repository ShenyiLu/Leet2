package medium;

public class L307NumArray {
    int[] sum;
    int[] nums;
    public L307NumArray(int[] nums) {
        if (nums.length == 0) {
            sum = null;
            return;
        }

        sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        this.nums = nums;
    }

    public void update(int i, int val) {
        nums[i] = val;
        if (i == 0) {
            sum[i] = val;
        }
        for (int j = Math.max(i, 1); j  < nums.length; j++) {
            sum[j] = sum[j - 1] + nums[j];
        }
    }

    public int sumRange(int i, int j) {
        if (sum == null) {
            return 0;
        }

        if (i == 0) {
            return sum[j];
        }

        return sum[j] - sum[i - 1];
    }
}

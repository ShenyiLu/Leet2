package easy;

public class L665NonDecreaseArray {
    public boolean checkPossibility(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        int modified = 0;
        for (int i = 1, prev = nums[0]; i < nums.length; i++) {
            if (nums[i] < prev && modified++ > 0) return false;
            if (nums[i] < prev && i - 2 >= 0 && nums[i - 2] > nums[i]) continue;
            prev = nums[i];
        }
        return true;
    }
}

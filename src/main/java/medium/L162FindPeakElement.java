package medium;

public class L162FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int slow = 0;
        int fast = 1;
        while(fast < nums.length) {
            if (nums[slow] > nums[fast]) {
                return slow;
            }
            slow++;
            fast++;
        }
        return slow;
    }
}

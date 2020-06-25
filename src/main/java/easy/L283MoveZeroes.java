package easy;

public class L283MoveZeroes {
    public void moveZeroes(int[] nums) {
        int fast = 0;
        int slow = 0;

        while (fast < nums.length) {
            while (fast < nums.length && nums[fast] == 0) {
                fast++;
            }
            if (fast < nums.length) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        while (slow < nums.length) {
            nums[slow] = 0;
            slow++;
        }
    }
}

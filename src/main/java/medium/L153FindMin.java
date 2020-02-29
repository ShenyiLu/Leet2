package medium;

public class L153FindMin {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }

        if (start == end - 1) {
            return Math.min(nums[start], nums[end]);
        }

        if (nums[start] < nums[end]) {
            return nums[start];
        }

        int pivotIndex = (start + end) / 2;
        int firstHalf = findMin(nums, start, pivotIndex);
        int secondHalf = findMin(nums, pivotIndex + 1, end);
        return Math.min(firstHalf, secondHalf);
    }
}

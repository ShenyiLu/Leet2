package medium;

public class L1060MissingElement {
    public int missingElement(int[] nums, int k) {
        int totalMissing = getMissingCount(nums, 0, nums.length - 1);
        if (k > totalMissing) {
            return nums[nums.length - 1] + k - totalMissing;
        }
        return divide(nums, k, 0, nums.length - 1);
    }

    private int divide(int[] nums, int k, int start, int end) {
        //see if k should between these two
        if (start == end - 1) {
            return nums[start] + k - getMissingCount(nums, 0, start);
        }

        int checkIndex = (start + end) / 2;
        int missingCheck = getMissingCount(nums, 0, checkIndex);
//        if (missingCheck == k) {
//            return nums[checkIndex];
//        } else
            if (missingCheck < k) {
            return divide(nums, k, checkIndex, end);
        } else {
            return divide(nums, k, start, checkIndex);
        }
    }

    private int getMissingCount(int[] nums, int start, int end) {
        return nums[end] - nums[start] - (end - start);
    }
}

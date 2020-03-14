package medium;

public class L334IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= smallest) {
                smallest = nums[i];
            } else if (nums[i] <= secondSmallest) {
                secondSmallest = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}

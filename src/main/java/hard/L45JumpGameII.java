package hard;

public class L45JumpGameII {
    public int jump(int[] nums) {
        int length = nums.length;

        int[] steps = new int[length];
        for (int i = 0; i < length; i++) {
            steps[i] = Integer.MAX_VALUE;
        }
        steps[0] = 0;

        for (int i = 0; i < length; i++) {
            int currentStep = steps[i];
            for (int j = i + 1; j < Math.min(i + nums[i] + 1, length); j++){
                steps[j] = Math.min(steps[j], currentStep + 1);
                if (j == length - 1) {
                    return steps[j];
                }
            }
        }
        return steps[length - 1];
    }
}

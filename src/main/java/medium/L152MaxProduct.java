package medium;

public class L152MaxProduct {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int index = 1;
        int result = max;

        while (index < nums.length) {
            int current = nums[index];
            int lastMax = max;
            int lastMin = min;

            max = Math.max(current, Math.max(lastMax * current, lastMin * current));
            System.out.println("max: " + max);
            min = Math.min(current, Math.min(lastMax * current, lastMin * current));
            System.out.println("min: " + min);
            index++;

            result = Math.max(result, max);
        }
        return result;
    }
}

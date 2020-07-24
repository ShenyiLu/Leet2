package easy;

public class L189RotateArray {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int index = 0;
        int count = nums.length;
        int[] copy = nums.clone();
        while (count-- > 0) {
            int nextIndex = (index + k) % nums.length;
            nums[nextIndex] = copy[index++];
        }
    }
}

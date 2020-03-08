package medium;

public class L209MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int head = 0;
        int tail = 0;
        int sum = 0;

        while (tail < nums.length) {
            while (tail < nums.length && sum < s) {
                sum += nums[tail++];
            }
            while (head < tail && sum >= s) {
                minLen = Math.min(minLen, tail - head);
                sum -= nums[head];
                head++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return 0;
        } else {
            return minLen;
        }

    }
}

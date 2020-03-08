package medium;

import java.util.ArrayList;
import java.util.List;

public class L228SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }

        if (nums.length == 1) {
            result.add(rangeToString(nums, 0, 0));
            return result;
        }

        int head = 0;
        int tail = 0;
        while (tail < nums.length) {
            while (tail < nums.length && (nums[tail] - nums[head] == tail - head)) {
                tail++;
            }
            result.add(rangeToString(nums, head, tail - 1));
            head = tail;
        }
        return result;
    }

    public String rangeToString(int[] nums, int head, int tail) {
        if (head == tail) {
            return "" + nums[head];
        }
        return nums[head] + "->" + nums[tail];
    }
}

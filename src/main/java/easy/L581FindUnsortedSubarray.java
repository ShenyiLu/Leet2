package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class L581FindUnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {
        List<Integer> sortedList = new ArrayList<>();
        for (int num : nums) {
            sortedList.add(num);
        }
        Collections.sort(sortedList);
        int head = 0;
        int tail = nums.length - 1;
        while (head < nums.length && nums[head] == sortedList.get(head)) {
            head++;
        }
        if (head == nums.length) {
            return 0;
        }
        while (tail >= 0 && nums[tail] == sortedList.get(tail)) {
            tail--;
        }
        return tail - head + 1;
    }
}

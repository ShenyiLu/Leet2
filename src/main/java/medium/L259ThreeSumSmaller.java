package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L259ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        List<Integer> number = new ArrayList<>();
        for (int i : nums) {
            number.add(i);
        }
        Collections.sort(number);
        int result = 0;

        int lastIndex = 2;
        while (lastIndex < number.size()) {
            int lastNum = number.get(lastIndex);
            int currTarget = target - lastNum;
            for (int j = lastIndex - 1; j >= 1; j--) {
                int i = j - 1;
                while (i >= 0 && number.get(i) + number.get(j) >= currTarget) {
                    i--;
                }
                result += (i + 1);
            }
            lastIndex++;
        }
        return result;
    }
}
